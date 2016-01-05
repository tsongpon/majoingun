package com.abctechthailand.majoingun.repository;

import com.abctechthailand.majoingun.domain.Prospect;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface ProspectRepository extends CrudRepository<Prospect, Long> {

    Prospect findByEmailAddress(String emailAddress);
}
