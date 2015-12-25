package com.majoingun.service;

import com.majoingun.domain.Prospect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
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

    private JavaMailSender mailSender;
    private FreeMarkerConfigurationFactory freeMarkerConfigurationFactory;

    @Autowired
    public MailService(JavaMailSender mailSender, FreeMarkerConfigurationFactory freeMarkerConfigurationFactory) {
        this.mailSender = mailSender;
        this.freeMarkerConfigurationFactory = freeMarkerConfigurationFactory;
    }

    @Async
    public void sendMailTo(Prospect prospect) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", prospect.getFirstName());
        String mailBody = "";
        try {
            mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(
                    freeMarkerConfigurationFactory.createConfiguration().getTemplate("mailtemplate.ftl"), map);
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
            e.printStackTrace();
        }

    }
}
