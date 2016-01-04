package com.majoingun.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Data
@Entity
@Table(name = "applicant",indexes = {@Index(columnList = "emailaddress")})
public class Applicant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "emailaddress", nullable = false, unique = true)
    private String emailAddress;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "contactNumber", nullable = false)
    private String contactNumber;

    @Column(name = "dateofbirth", nullable = false)
    private LocalDateTime dateOfBirth;

    @Column(name = "major")
    private String major;

    @Column(name = "yearofexperience")
    private Integer yearOfExperience;

    @ManyToOne(targetEntity = EducationLevel.class)
    @JoinColumn(name = "educationlevel_id")
    private EducationLevel highestEducationLevel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "applicant", cascade = CascadeType.ALL)
    private List<Certificate> certificates;

    @ManyToOne(targetEntity = JobPosition.class)
    @JoinColumn(name = "jobposition_id")
    private JobPosition interestedJobPosition;

    @Column(name = "introducemessage", length = 1000)
    private String introduceMessage;

    public void addCertificate(Certificate certificate) {
        if (certificates == null) {
            certificates = new ArrayList<>();
        }
        certificate.setApplicant(this);
        certificates.add(certificate);
    }
}
