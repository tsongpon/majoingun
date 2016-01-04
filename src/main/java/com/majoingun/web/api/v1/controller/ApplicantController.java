package com.majoingun.web.api.v1.controller;

import com.majoingun.domain.Applicant;
import com.majoingun.service.ApplicantService;
import com.majoingun.web.api.v1.mapper.ApplicantMapper;
import com.majoingun.web.api.v1.transport.ApplicantTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

@RestController
public class ApplicantController {

    private Logger log = LoggerFactory.getLogger(ApplicantController.class);

    private ApplicantService applicantService;
    private ApplicantMapper mapper;

    @Autowired
    public ApplicantController(ApplicantService applicantService, ApplicantMapper applicantMapper) {
        this.applicantService = applicantService;
        this.mapper = applicantMapper;
    }

    @RequestMapping(value = "/api/majoingun/v1/applicants", method = RequestMethod.POST)
    public ResponseEntity<?> saveNewApplicant(@RequestBody @Valid ApplicantTransport applicantTransport, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            List<String> errMsgList = new ArrayList<>();
            for(ObjectError err: bindingResult.getAllErrors()) {
                String errorMsg = err.getDefaultMessage();
                errMsgList.add(errorMsg);
            }
            return new ResponseEntity<>(errMsgList, HttpStatus.BAD_REQUEST);
        }
        log.info("Saving new applicant");
        Applicant applicant = mapper.map(applicantTransport);
        Applicant savedApplicant = applicantService.saveApplicant(applicant);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedApplicant.getId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }
}
