package com.majoingun.web.api.v1.mapper;

import com.majoingun.domain.JobPosition;
import com.majoingun.web.api.v1.transport.JobPositionTransport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */

@Component
public class JobPositionMapper {

    public JobPositionTransport map(JobPosition jobPosition) {
        JobPositionTransport transport = new JobPositionTransport();
        transport.setId(jobPosition.getId());
        transport.setName(jobPosition.getPositionName());

        return transport;
    }

    public List<JobPositionTransport> map(List<JobPosition> jobPositions) {
        return jobPositions.stream().map(this::map).collect(Collectors.toList());
    }
}
