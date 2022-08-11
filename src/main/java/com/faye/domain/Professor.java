package com.faye.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor_generator")
    @SequenceGenerator(name="professor_generator", sequenceName = "professor_seq", allocationSize=100)
    private Long id;
    private Long matricule;
    private String grade;
    private String name;
    private String speciality;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer")
    private University employer;

    public Professor(Long matricule, String grade, String name, String speciality, University employer) {
        this.matricule = matricule;
        this.grade = grade;
        this.name = name;
        this.speciality = speciality;
        this.employer = employer;
    }
}
