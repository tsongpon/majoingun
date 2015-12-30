package com.majoingun.web.api.v1.mapper;

import com.majoingun.domain.Applicant;
import com.majoingun.domain.Certificate;
import com.majoingun.service.EducationLevelService;
import com.majoingun.service.JobPositionService;
import com.majoingun.web.api.v1.transport.ApplicantTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

@Component
public class ApplicantMapper {

    private EducationLevelService educationLevelService;
    private JobPositionService jobPositionService;

    @Autowired
    public ApplicantMapper(EducationLevelService educationLevelService, JobPositionService jobPositionService) {
        this.educationLevelService = educationLevelService;
        this.jobPositionService = jobPositionService;
    }

    public Applicant map(ApplicantTransport transport) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(transport.getFirstName());
        applicant.setLastName(transport.getLastName());
        applicant.setContactNumber(transport.getContactNumber());
        applicant.setEmailAddress(transport.getEmailAddress());
        applicant.setYearOfExperience(transport.getYearOfExperience());
        applicant.setMajor(transport.getMajor());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(transport.getDateOfBirth(), formatter);
        applicant.setDateOfBirth(dateTime.atStartOfDay());

        List<Certificate> certificates = new ArrayList<>();
        if(!StringUtils.isEmpty(transport.getCertificatesOne())) {
            Certificate certificate = new Certificate();
            certificate.setCertificateName(transport.getCertificatesOne());
            certificate.setApplicant(applicant);
            certificates.add(certificate);
        }

        if(!StringUtils.isEmpty(transport.getCertificatesTwo())) {
            Certificate certificate = new Certificate();
            certificate.setCertificateName(transport.getCertificatesTwo());
            certificate.setApplicant(applicant);
            certificates.add(certificate);
        }


        if(!StringUtils.isEmpty(transport.getCertificatesThree())) {
            Certificate certificate = new Certificate();
            certificate.setCertificateName(transport.getCertificatesThree());
            certificate.setApplicant(applicant);
            certificates.add(certificate);
        }

        if(!StringUtils.isEmpty(transport.getCertificatesFour())) {
            Certificate certificate = new Certificate();
            certificate.setCertificateName(transport.getCertificatesFour());
            certificate.setApplicant(applicant);
            certificates.add(certificate);
        }

        if(certificates.size() > 0) {
            applicant.setCertificates(certificates);
        }

        applicant.setInterestedJobPosition(jobPositionService.findById(transport.getInterestedJobPosition()));

        applicant.setHighestEducationLevel(educationLevelService.findById(transport.getEducationLevel()));

        return applicant;
    }
}
