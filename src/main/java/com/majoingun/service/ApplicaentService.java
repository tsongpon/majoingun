package com.majoingun.service;

import com.majoingun.domain.Applicant;
import com.majoingun.repository.ApplicantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ApplicaentService {

    //private Logger log = LoggerFactory.getLogger(ApplicaentService.super);

    private ApplicantRepository applicantRepository;

    public ApplicaentService (ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

//    public Applicant saveApplicant(Applicant applicant) {
//        log.info("saving applicant with email address {}", applicant.getEmailAddress());
//        Applicant savedApplicent = applicantRepository.save(applicant);
//    }
}
