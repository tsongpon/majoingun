package com.majoingun.controller;

import com.majoingun.domain.Applicant;
import com.majoingun.domain.JobFunction;
import com.majoingun.domain.JobPosition;
import com.majoingun.domain.Prospect;
import com.majoingun.enumuration.Gender;
import com.majoingun.enumuration.ProspectType;
import com.majoingun.repository.ApplicantRepository;
import com.majoingun.repository.JobFunctionRepository;
import com.majoingun.repository.JobPositionRepository;
import com.majoingun.repository.ProspectRepository;
import com.majoingun.service.MailService;
import com.majoingun.service.ProspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

@RestController
public class TestController {

    @Autowired
    private JobFunctionRepository jobFunctionRepository;

    @Autowired
    private ProspectRepository prospectRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private JobPositionRepository jobPositionRepository;

    @Autowired
    private ProspectService prospectService;

    @Autowired
    private ApplicantRepository applicantRepository;

    @RequestMapping("/save")
    public String save() {
        //JobFunction savedJobFunction = jobFunctionRepository.save(jobFunction);
        JobFunction jobFunction = jobFunctionRepository.findOne(1L);

        List<JobFunction> jobFunctions = new ArrayList<>();
        jobFunctions.add(jobFunction);

        Prospect prospect = new Prospect();
        prospect.setEmailAddress("tum@abctech-thailand.com");
        prospect.setFirstName("songpon");
        prospect.setLastName("imyen");
        prospect.setGender(Gender.MALE);
        prospect.setRegisterTime(LocalDateTime.now());
        prospect.setProspectType(ProspectType.INTERN);
        prospect.setUniversityName("KMITL");
        prospect.setInterestedJobFunction(jobFunctions);

        prospectService.saveNewProspect(prospect);

        return "saved";
    }

    @RequestMapping("/find/{id}")
    public String find(@PathVariable Long id) {

        Applicant applicant = applicantRepository.findOne(id);
        return Integer.toString(applicant.getCertificates().size());
    }

}
