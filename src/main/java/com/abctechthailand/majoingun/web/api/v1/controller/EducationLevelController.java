package com.abctechthailand.majoingun.web.api.v1.controller;

import com.abctechthailand.majoingun.domain.EducationLevel;
import com.abctechthailand.majoingun.service.EducationLevelService;
import com.abctechthailand.majoingun.web.api.v1.mapper.EducationMapper;
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
public class EducationLevelController {

    private EducationMapper mapper;
    private EducationLevelService educationLevelService;

    @Autowired
    public EducationLevelController(EducationLevelService educationLevelService, EducationMapper educationMapper) {
        this.educationLevelService = educationLevelService;
        this.mapper = educationMapper;
    }

    @RequestMapping(value = "/api/majoingun/v1/educationlevels", method = RequestMethod.GET)
    public ResponseEntity<?> listEducationLevel() {
        List<EducationLevel> educationLevelList = educationLevelService.listAll();

        return new ResponseEntity<>(mapper.map(educationLevelList), HttpStatus.OK);
    }
}
