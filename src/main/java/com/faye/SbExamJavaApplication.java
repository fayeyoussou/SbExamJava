package com.faye;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.faye.domain.Professor;
import com.faye.domain.ProfessorRepository;
import com.faye.domain.University;
import com.faye.domain.UniversityRepository;


@SpringBootApplication
public class SbExamJavaApplication implements CommandLineRunner{

    private static final Logger logger =
            LoggerFactory.getLogger(SbExamJavaApplication.class);

    @Autowired
    private ProfessorRepository p_repository;


    @Autowired
    private UniversityRepository u_repository;

    public static void main(String[] args) {
        SpringApplication.run(SbExamJavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        University u1 = new University("UCAD", "Universite Cheikh Anta Diop", "Ahmadou Aly MBAYE", 53000);
        University u2 = new  University("UGB", "Universite Gaston Berger", "Ousmane THIARE", 39000);
        u_repository.saveAll(Arrays.asList(u1, u2));

        Professor p1 = new Professor(1920L, "Full Professor", "Samba Ndiaye", "Software Engineering", u1);
        Professor p2 = new Professor(3829L, "Associate Professor", "Mandicou Ba", "Systems and Languages", u1);
        Professor p3 = new Professor(9482L, "Lecturer", "David Faye", "Databases", u2);
        p_repository.saveAll(Arrays.asList(p1, p2, p3));

        for (Professor p : p_repository.findAll()) {
            logger.info(p.getName() + " : " + p.getGrade() +", works for " +p.getEmployer().getName());
        }
    }

}
