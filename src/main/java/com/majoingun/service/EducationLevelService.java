package com.majoingun.service;

import com.google.common.collect.Lists;
import com.majoingun.domain.EducationLevel;
import com.majoingun.repository.EducationLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class EducationLevelService {

    private EducationLevelRepository educationLevelRepository;

    @Autowired
    public EducationLevelService(EducationLevelRepository educationLevelRepository) {
        this.educationLevelRepository = educationLevelRepository;
    }

    public List<EducationLevel> listAll() {
        return Lists.newArrayList(educationLevelRepository.findAll());
    }

    public EducationLevel findById(Long id) {
        return educationLevelRepository.findOne(id);
    }
}
