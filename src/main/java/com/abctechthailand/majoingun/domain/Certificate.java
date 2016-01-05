package com.abctechthailand.majoingun.domain;

import lombok.Data;

import javax.persistence.*;

/**
 *
 */
@Data
@Entity
@Table(name = "certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "certificatename")
    private String CertificateName;

    @ManyToOne(targetEntity = Applicant.class)
    private Applicant applicant;
}
