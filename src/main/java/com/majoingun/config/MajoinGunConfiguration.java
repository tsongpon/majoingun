package com.majoingun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;

import java.util.Properties;

/**
 *
 */

@Configuration
@EnableAsync
public class MajoinGunConfiguration {

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setUsername("classify.amedia@gmail.com");
        sender.setPassword("abctechthailand");

        Properties sendMailProperties = new Properties();
        sendMailProperties.setProperty("mail.smtp.auth", "true");
        sendMailProperties.setProperty("mail.smtp.starttls.enable", "true");

        sender.setJavaMailProperties(sendMailProperties);

        return sender;
    }

    @Bean
    public FreeMarkerConfigurationFactory freeMarkerConfigurationFactory(){
        FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
        factory.setTemplateLoaderPath("classpath:templates");
        factory.setPreferFileSystemAccess(false);
        factory.setDefaultEncoding("utf-8");
        return factory;
    }
}
