package com.majoingun.web.api.v1.mapper;

import com.majoingun.domain.JobFunction;
import com.majoingun.domain.Prospect;
import com.majoingun.enumuration.Gender;
import com.majoingun.enumuration.ProspectType;
import com.majoingun.repository.JobFunctionRepository;
import com.majoingun.web.api.v1.transport.ProspectTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProspectTransportMapper {
    private Logger log = LoggerFactory.getLogger(ProspectTransportMapper.class);
    private JobFunctionRepository jobFunctionRepository;

    @Autowired
    public ProspectTransportMapper(JobFunctionRepository jobFunctionRepository){
        this.jobFunctionRepository = jobFunctionRepository;
    }

    public ProspectTransport map(Prospect prospect) {
        ProspectTransport transport = new ProspectTransport();
        transport.setFirstName(prospect.getFirstName());
        transport.setLastName(prospect.getLastName());
        transport.setEmail(prospect.getEmailAddress());
        transport.setUniversity(prospect.getUniversityName());
        transport.setMobile(prospect.getTelephoneNumber());

        return transport;
    }

    public List<ProspectTransport> map(List<Prospect> prospects) {
        return prospects.stream().map(this::map).collect(Collectors.toList());
    }

    public Prospect map(ProspectTransport prospectTransport){
        Prospect transport = new Prospect();
        try {
            transport.setFirstName(prospectTransport.getFirstName());
            transport.setLastName(prospectTransport.getLastName());
            transport.setEmailAddress(prospectTransport.getEmail());
            transport.setTelephoneNumber(prospectTransport.getMobile());
            if(prospectTransport.getGender().equalsIgnoreCase("male")){
                transport.setGender(Gender.MALE);
            }
            if(prospectTransport.getGender().equalsIgnoreCase("female")){
                transport.setGender(Gender.FEMALE);
            }
            List<JobFunction> jobFunctionList = new ArrayList<>();
            if(!StringUtils.isEmpty(prospectTransport.getInterestedFields())){
                for(String str: prospectTransport.getInterestedFields()){
                    JobFunction jobFunction = jobFunctionRepository.findByFunctionName(str);
                    jobFunctionList.add(jobFunction);
                }
            }
            transport.setInterestedJobFunction(jobFunctionList);
            transport.setUniversityName(prospectTransport.getUniversity());
            if(prospectTransport.getType().equalsIgnoreCase("intern")){
                transport.setProspectType(ProspectType.INTERN);
            }
            if(prospectTransport.getType().equalsIgnoreCase("permanent")){
                transport.setProspectType(ProspectType.PERMANENT);
            }
            transport.setRegisterTime(LocalDateTime.now());
        }catch (Exception e){
            log.error("Could not read document", e);
            throw new HttpMessageNotReadableException(e.getMessage());
        }

        return transport;
    }

    public List<Prospect> mapList(List<ProspectTransport> prospectTransports){
        return prospectTransports.stream()
                .map(this::map).collect(Collectors.toList());
    }


}