package com.majoingun.controller;

import com.majoingun.domain.JobFunction;
import com.majoingun.domain.Prospect;
import com.majoingun.enumuration.Gender;
import com.majoingun.enumuration.ProspectType;
import com.majoingun.repository.JobFunctionRepository;
import com.majoingun.repository.ProspectRepository;
import com.majoingun.service.MailService;
import com.majoingun.service.ProspectService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ProspectService prospectService;

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

        prospectService.saveNewProoect(prospect);

        return "saved";
    }

    @RequestMapping("/find")
    public Prospect find() {
        Prospect prospect = prospectRepository.findByEmailAddress("tum@abc.io");

        return prospect;
    }

}
