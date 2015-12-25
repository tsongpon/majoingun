package com.majoingun.service;

import com.majoingun.domain.Prospect;
import com.majoingun.repository.ProspectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ProspectService {

    private Logger log = LoggerFactory.getLogger(ProspectService.class);

    private ProspectRepository prospectRepository;
    private MailService mailService;

    @Autowired
    public ProspectService(ProspectRepository prospectRepository, MailService mailService) {
        this.prospectRepository = prospectRepository;
        this.mailService = mailService;
    }

    public void saveNewProoect(Prospect prospect) {
        log.info("Saving prospect with email {}", prospect.getEmailAddress());
        Prospect savedProspect =  prospectRepository.save(prospect);
        mailService.sendMailTo(savedProspect);
    }
}
