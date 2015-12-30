package com.majoingun.web.api.v1.transport;

import lombok.Data;

@Data
public class ProspectTransport {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String mobile;
    private String university;
    private String interestedFields[];
    private String type;
}
