package com.majoingun.web.api.v1.transport;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Data
public class ProspectTransport {

    @NotBlank(message = "First name can not be blank")
    private String firstName;

    @NotBlank(message = "Last name can not be blank")
    private String lastName;

    @NotBlank(message = "Please select gender")
    private String gender;

    @NotBlank(message = "E-mail address us required")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message="Mobile phone must be a number")
    private String mobile;

    @NotBlank(message = "University is required")
    private String university;

    @NotBlank(message = "Please select interested fields")
    private String interestedFields[];

    @NotBlank(message = "Please chose intern or permanent")
    private String type;
}
