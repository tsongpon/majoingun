package com.abctechthailand.majoingun.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Data
@Entity
@Table(name = "jobfunction")
public class JobFunction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String functionName;
//    @ManyToMany(mappedBy="interestedJobFunction", fetch = FetchType.LAZY)
//    private List<Prospect> registrars;
}
