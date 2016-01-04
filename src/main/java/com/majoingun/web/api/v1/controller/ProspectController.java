package com.majoingun.web.api.v1.controller;

import com.majoingun.domain.Prospect;
import com.majoingun.service.ProspectService;
import com.majoingun.web.api.v1.mapper.ProspectTransportMapper;
import com.majoingun.web.api.v1.transport.ProspectTransport;
import com.majoingun.web.transport.ErrorResponseTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProspectController {

    @Autowired
    private ProspectService prospectService;

    @Autowired
    private ProspectTransportMapper mapper;

    @RequestMapping(value = "/api/majoingun/v1/prospects", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> saveNewProspect(@RequestBody @Valid ProspectTransport prospectTransport,
                                             BindingResult result){
        String errorMessage = "";
        if(result.hasErrors()){
            List<String> errMsgList = new ArrayList<>();
            for(ObjectError err: result.getAllErrors()) {
                String errorMsg = err.getDefaultMessage();
                errorMessage = errorMessage + errorMsg + "<br>";
            }
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        Prospect prospect = mapper.map(prospectTransport);
        Prospect savedProspect = prospectService.saveNewProspect(prospect);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProspect.getId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "api/majoingun/v1/prospects", method = RequestMethod.GET)
    public ResponseEntity<?> listAllProspect() {
        List<Prospect> prospects = prospectService.listProspect();

        return new ResponseEntity<>(mapper.map(prospects), HttpStatus.OK);
    }
}

