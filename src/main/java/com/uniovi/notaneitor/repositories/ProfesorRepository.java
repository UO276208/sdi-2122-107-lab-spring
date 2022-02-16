package com.uniovi.notaneitor.repositories;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
}
