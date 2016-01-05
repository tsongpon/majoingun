package com.majoingun.web.api.v1.transport;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

@Data
public class ProspectTransport {

    @NotBlank(message = "First name can not be blank")
    private String firstName;

    @NotBlank(message = "Last name can not be blank")
    private String lastName;

    @NotBlank(message = "Please select gender")
    private String gender;

    @NotBlank(message = "E-mail address cannot be blank")
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "Invalid email address format")
    private String email;

    @NotBlank(message = "Contact number cannot be blank")
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message="Mobile phone must be a number")
    private String mobile;

    @NotBlank(message = "University cannot be blank")
    private String university;

    @NotEmpty(message = "Please select interested field(s)")
    private String interestedFields[];

    @NotBlank(message = "Please select intern or permanent")
    private String type;
}
