package com.abctechthailand.majoingun.web.api.v1.mapper;

import com.abctechthailand.majoingun.domain.University;
import com.abctechthailand.majoingun.web.api.v1.transport.UniversityTransport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Component
public class UniversityMapper {

    public UniversityTransport map(University university) {
        UniversityTransport transport = new UniversityTransport();
        transport.setId(university.getId());
        transport.setName(university.getName());

        return transport;
    }

    public List<UniversityTransport> map(List<University> universities) {
        return universities.stream().map(this::map).collect(Collectors.toList());
    }
}
