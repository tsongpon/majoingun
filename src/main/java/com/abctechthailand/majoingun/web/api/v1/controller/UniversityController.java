package com.abctechthailand.majoingun.web.api.v1.controller;

import com.abctechthailand.majoingun.domain.University;
import com.abctechthailand.majoingun.service.UniversityService;
import com.abctechthailand.majoingun.web.api.v1.mapper.UniversityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */

@RestController
public class UniversityController {

    private UniversityService universityService;
    private UniversityMapper mapper;

    @Autowired
    public UniversityController(UniversityService service, UniversityMapper mapper) {
        this.universityService = service;
        this.mapper = mapper;
    }

    @RequestMapping(value = "/api/majoingun/v1/universities", method = RequestMethod.GET)
    public ResponseEntity<?> listAllUniversity() {
        List<University> universities = universityService.listAllUniversity();

        return new ResponseEntity<>(mapper.map(universities), HttpStatus.OK);
    }
}
