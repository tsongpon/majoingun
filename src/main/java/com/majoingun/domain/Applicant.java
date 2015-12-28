package com.majoingun.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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

    @Column(name = "title")
    private String title;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "contactNumber", nullable = false)
    private String contactNumber;

    @Column(name = "dateofbirth", nullable = false)
    private LocalDateTime dateOfBirth;

    @Column(name = "educationlevel")
    private String educationLevel;

    @Column(name = "major")
    private String major;

    @Column(name = "yearofexperience")
    private Integer yearOfExperience;

    //    private List<Certificate> certificates;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "applicant_jobposition",
            joinColumns =
            @JoinColumn(name = "applicant_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "jobposition_id", referencedColumnName = "id")
    )
    private List<JobPosition> interestedJobPosition;

    @Column(name = "introducemessage", length = 1000)
    private String introduceMessage;
}
