package com.majoingun.web.api.v1.mapper;

import com.majoingun.domain.JobFunction;
import com.majoingun.domain.Prospect;
import com.majoingun.enumuration.Gender;
import com.majoingun.enumuration.ProspectType;
import com.majoingun.repository.JobFunctionRepository;
import com.majoingun.web.api.v1.transport.ProspectTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProspectTransportMapper {
    private JobFunctionRepository jobFunctionRepository;

    @Autowired
    public ProspectTransportMapper(JobFunctionRepository jobFunctionRepository){
        this.jobFunctionRepository = jobFunctionRepository;
    }

    public Prospect map(ProspectTransport prospectTransport){
        Prospect transport = new Prospect();
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
            String interestFields[] = prospectTransport.getInterestedFields().split(",");
            for(String str: interestFields){
                JobFunction jobFunction = jobFunctionRepository.findByFunctionName(str);
                jobFunctionList.add(jobFunction);
            }
        }
        transport.setInterestedJobFunction(jobFunctionList);
        transport.setUniversityName(prospectTransport.getUniversity());
        if(prospectTransport.getType().equalsIgnoreCase("intern")){
            transport.setProspectType(ProspectType.INTERN);
        }
        if(prospectTransport.getGender().equalsIgnoreCase("permanent")){
            transport.setProspectType(ProspectType.PERMANENT);
        }

        return transport;
    }

    public List<Prospect> mapList(List<ProspectTransport> prospectTransports){
        return prospectTransports.stream()
                .map(this::map).collect(Collectors.toList());
    }


}