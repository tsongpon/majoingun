package com.majoingun.web.api.v1.transport;

import lombok.Data;

/**
 *
 */

@Data
public class ApplicantTransport {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String contactNumber;
    private String dateOfBirth;
    private Long educationLevel;
    private String major;
    private Integer yearOfExperience;
    private Long interestedJobPosition;
    private String introduceMessage;
    private String certificatesOne;
    private String certificatesTwo;
    private String certificatesThree;
    private String certificatesFour;
    private String availability;
    private Integer latestSalary;
}
