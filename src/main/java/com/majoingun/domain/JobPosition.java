package com.majoingun.domain;

import lombok.Data;

import javax.persistence.*;

/**
 *
 */
@Data
@Entity
@Table(name = "jobposition")
public class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String positionName;
}
