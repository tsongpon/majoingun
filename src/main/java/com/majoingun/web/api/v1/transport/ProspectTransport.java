package com.majoingun.web.api.v1.transport;

import com.majoingun.domain.JobFunction;
import com.majoingun.enumuration.Gender;
import com.majoingun.enumuration.ProspectType;
import lombok.Data;

import java.util.List;

@Data
public class ProspectTransport {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String mobile;
    private String university;
    private String interestedFields;
    private String type;
}
