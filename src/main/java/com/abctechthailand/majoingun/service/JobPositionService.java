package com.abctechthailand.majoingun.service;

import com.abctechthailand.majoingun.domain.JobPosition;
import com.google.common.collect.Lists;
import com.abctechthailand.majoingun.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */

@Service
public class JobPositionService {

    private JobPositionRepository jobPositionRepository;

    @Autowired
    public JobPositionService(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

    public List<JobPosition> listAll() {
        return Lists.newArrayList(jobPositionRepository.findAll());
    }

    public JobPosition findById(Long id) {
        return jobPositionRepository.findOne(id);
    }
}
