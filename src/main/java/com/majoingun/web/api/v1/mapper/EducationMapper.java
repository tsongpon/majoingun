package com.majoingun.web.api.v1.mapper;

import com.majoingun.domain.EducationLevel;
import com.majoingun.web.api.v1.transport.EducationLevelTransport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Component
public class EducationMapper {

    public EducationLevelTransport map(EducationLevel educationLevel) {
        EducationLevelTransport transport = new EducationLevelTransport();
        transport.setId(educationLevel.getId());
        transport.setName(educationLevel.getName());

        return transport;
    }

    public List<EducationLevelTransport> map(List<EducationLevel> educationLevels) {
        return educationLevels.stream().map(this::map).collect(Collectors.toList());
    }
}
