package com.majoingun.repository;

import com.majoingun.domain.JobPosition;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface JobPositionRepository extends CrudRepository <JobPosition, Long > {

    JobPosition findByPositionName (String positionName);
}
