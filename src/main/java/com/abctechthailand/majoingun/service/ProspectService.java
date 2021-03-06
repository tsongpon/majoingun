package com.abctechthailand.majoingun.service;

import com.abctechthailand.majoingun.repository.ProspectRepository;
import com.google.common.collect.Lists;
import com.abctechthailand.majoingun.domain.Prospect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Prospect saveNewProspect(Prospect prospect) {
        log.info("Saving prospect with email {}", prospect.getEmailAddress());
        Prospect savedProspect = new Prospect();
        try {
            log.info("Try to save new prospect {}", prospect.getEmailAddress());
            savedProspect =  prospectRepository.save(prospect);
            mailService.sendMailTo(savedProspect);
        }catch (Exception e){
            log.error("Could not save data into database");
            throw new MappingException(e.getMessage());
        }
        return savedProspect;
    }

    public List<Prospect> listProspect() {
        log.info("Listing all prospect");
        return Lists.newArrayList(prospectRepository.findAll());
    }
}
