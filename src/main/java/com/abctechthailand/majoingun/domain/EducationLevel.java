package com.abctechthailand.majoingun.domain;

import lombok.Data;

import javax.persistence.*;

/**
 *
 */
@Data
@Entity
@Table(name = "educationlevel")
public class EducationLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
}
