package com.majoingun.repository;

import com.majoingun.domain.Prospect;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface ProspectRepository extends CrudRepository<Prospect, Long> {

    Prospect findByEmailAddress(String emailAddress);
}
