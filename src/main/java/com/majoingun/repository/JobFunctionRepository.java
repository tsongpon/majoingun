package com.majoingun.repository;

import com.majoingun.domain.JobFunction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface JobFunctionRepository extends CrudRepository<JobFunction, Long> {

    JobFunction findByFunctionName( String functionName );
}
