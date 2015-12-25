package com.majoingun.domain;

import lombok.Data;

import javax.persistence.*;

/**
 *
 */
@Data
@Entity
@Table(name = "jobfunction")
public class JobFunction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String functionName;
//    @ManyToMany(mappedBy="interestedJobFunction", fetch = FetchType.LAZY)
//    private List<Prospect> registrars;
}
