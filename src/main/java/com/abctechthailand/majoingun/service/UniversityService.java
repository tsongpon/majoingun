package com.abctechthailand.majoingun.service;

import com.abctechthailand.majoingun.domain.University;
import com.abctechthailand.majoingun.repository.UniversityRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class UniversityService {

    private UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> listAllUniversity() {
        List<University> universities = Lists.newArrayList(universityRepository.findAll());
        List<University> sortedUniversity = universities.stream().
                sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
        return Lists.newArrayList(sortedUniversity);
    }
}
