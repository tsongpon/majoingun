package com.abctechthailand.majoingun.service;

import com.abctechthailand.majoingun.exception.MajoingunException;
import com.abctechthailand.majoingun.domain.Applicant;
import com.abctechthailand.majoingun.domain.Prospect;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Service
public class MailService {

    private Logger log = org.slf4j.LoggerFactory.getLogger(MailService.class);

    private JavaMailSender mailSender;
    private FreeMarkerConfigurationFactory freeMarkerConfigurationFactory;

    @Autowired
    public MailService(JavaMailSender mailSender, FreeMarkerConfigurationFactory freeMarkerConfigurationFactory) {
        this.mailSender = mailSender;
        this.freeMarkerConfigurationFactory = freeMarkerConfigurationFactory;
    }

    @Async
    public void sendMailTo(Applicant applicant) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", applicant.getFirstName());
        String mailBody = "";
        try {
            mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(
                    freeMarkerConfigurationFactory.createConfiguration().getTemplate("applicant_mailtemplate.ftl"), map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom("noreply@abctech.io");
            helper.setTo(applicant.getEmailAddress());
            helper.setSubject("Your application has been processed");
            message.setContent(mailBody, "text/html; charset=utf-8");
            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Cannot sent mail to applicant {}", applicant.getEmailAddress(), e);
            throw new MajoingunException(e);
        }
    }

    @Async
    public void sendMailTo(Prospect prospect) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", prospect.getFirstName());
        String mailBody = "";
        try {
            mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(
                    freeMarkerConfigurationFactory.createConfiguration().getTemplate("prospect_mailtemplate.ftl"), map);
        } catch (Exception e) {
          e.printStackTrace();
        }

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom("noreply@abctech.io");
            helper.setTo(prospect.getEmailAddress());
            helper.setSubject("Welcome to abctech");
            message.setContent(mailBody, "text/html; charset=utf-8");
            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Cannot sent mail to prospect {}", prospect.getEmailAddress(), e);
            throw new MailSendException(e.getMessage());
        }
//        catch (MailException ex){
//            log.error("Invalid recipient address");
//            throw new MailSendException(ex.getMessage());
//        }

    }
}
