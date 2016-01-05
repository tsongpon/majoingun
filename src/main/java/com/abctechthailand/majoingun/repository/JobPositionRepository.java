package com.abctechthailand.majoingun.repository;

import com.abctechthailand.majoingun.domain.JobPosition;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface JobPositionRepository extends CrudRepository <JobPosition, Long > {

    JobPosition findByPositionName (String positionName);
}
