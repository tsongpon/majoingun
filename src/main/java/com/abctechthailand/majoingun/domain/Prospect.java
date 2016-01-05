package com.abctechthailand.majoingun.domain;

import com.abctechthailand.majoingun.enumuration.Gender;
import com.abctechthailand.majoingun.enumuration.ProspectType;
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
@Table(name = "prospect", indexes = {@Index(columnList = "emailaddress")})
public class Prospect implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "emailaddress", nullable = false)
    private String emailAddress;

    @Column(name = "telephonenumber", nullable = false)
    private String telephoneNumber;

    @Column(name = "universityname", nullable = false)
    private String universityName;

    @Column(name = "registrartype", nullable = false)
    private ProspectType prospectType;

    @Column(name = "registertime", nullable = false)
    private LocalDateTime registerTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="prospect_jobfunction",
            joinColumns=
            @JoinColumn(name="prospect_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="jobfunction_id", referencedColumnName="id")
    )
    private List<JobFunction> interestedJobFunction;
}
