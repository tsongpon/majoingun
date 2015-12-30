package com.majoingun.web.api.v1.transport;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

@Data
public class ProspectTransport {

    @NotEmpty(message = "First name can not be blank")
    private String firstName;

    @NotEmpty(message = "Las name can not be blank")
    private String lastName;

    private String gender;

    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "Invalid email address format")
    private String email;
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message="Mobile phone must be a number")
    private String mobile;

    private String university;

    private String interestedFields[];

    private String type;
}
