package com.majoingun.web.api.v1.transport;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 */

@Data
public class ApplicantTransport {
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;
    @NotBlank(message = "Email address cannot be blank")
    @Email(message = "Please input valid email address")
    private String emailAddress;
    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message="Mobile phone must be a number")
    private String contactNumber;
    private String dateOfBirth;
    private Long educationLevel;
    private String major;
    private Integer yearOfExperience;
    @NotNull(message = "Please select interested job position")
    private Long interestedJobPosition;
    private String introduceMessage;
    private String certificatesOne;
    private String certificatesTwo;
    private String certificatesThree;
    private String certificatesFour;
    private String availability;
    private Integer latestSalary;
}
