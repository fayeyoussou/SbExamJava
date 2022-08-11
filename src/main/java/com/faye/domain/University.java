package com.faye.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "university_generator")
    @SequenceGenerator(name="university_generator", sequenceName = "university_seq", allocationSize=100)
    private Long id;
    private String name;
    private String president;
    private String fullname;
    @OneToMany(mappedBy = "employer",fetch = FetchType.LAZY)
    private List<Professor> employees;
    private int capacity;

    public University(String name,String fullname, String president, int capacity) {
        this.name = name;
        this.president = president;
        this.fullname = fullname;
        this.capacity = capacity;
    }
}
