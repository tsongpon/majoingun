package com.majoingun.web.api.v1.controller;

import com.majoingun.domain.EducationLevel;
import com.majoingun.domain.JobPosition;
import com.majoingun.service.JobPositionService;
import com.majoingun.web.api.v1.mapper.JobPositionMapper;
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
public class JobPositionController {

    private JobPositionService jobPositionService;
    private JobPositionMapper mapper;

    @Autowired
    public JobPositionController(JobPositionService service, JobPositionMapper mapper) {
        this.jobPositionService = service;
        this.mapper = mapper;
    }

    @RequestMapping(value = "/api/majoingun/v1/jobpositions", method = RequestMethod.GET)
    public ResponseEntity<?> listEducationLevel() {
        List<JobPosition> jobPositions = jobPositionService.listAll();

        return new ResponseEntity<>(mapper.map(jobPositions), HttpStatus.OK);
    }
}
