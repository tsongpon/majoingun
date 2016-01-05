package com.abctechthailand.majoingun.service;

import com.abctechthailand.majoingun.repository.ApplicantRepository;
import com.abctechthailand.majoingun.domain.Applicant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ApplicantService {

    private Logger log = LoggerFactory.getLogger(ApplicantService.class);

    private ApplicantRepository applicantRepository;
    private MailService mailService;

    @Autowired
    public ApplicantService (ApplicantRepository applicantRepository, MailService mailService) {
        this.applicantRepository = applicantRepository;
        this.mailService = mailService;
    }

    public Applicant findById(Long id) {
        return applicantRepository.findOne(id);
    }

    public Applicant saveApplicant(Applicant applicant) {
        log.info("saving applicant, applicant email address {}", applicant.getEmailAddress());
        Applicant savedApplicant = applicantRepository.save(applicant);

        mailService.sendMailTo(applicant);

        return savedApplicant;
    }
}
