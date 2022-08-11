package com.faye.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends CrudRepository<Professor,Long> {
}
