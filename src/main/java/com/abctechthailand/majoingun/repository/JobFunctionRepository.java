package com.abctechthailand.majoingun.repository;

import com.abctechthailand.majoingun.domain.JobFunction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface JobFunctionRepository extends CrudRepository<JobFunction, Long> {

    JobFunction findByFunctionName( String functionName );
}
