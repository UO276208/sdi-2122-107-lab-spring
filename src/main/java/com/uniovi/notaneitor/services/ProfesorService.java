package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Profesor;
import com.uniovi.notaneitor.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> getProfesors() {
        List<Profesor> profesors = new ArrayList<Profesor>();
        profesorRepository.findAll().forEach(profesors::add);
        return profesors;
    }
    public Profesor getProfesor(Long id) {
        return profesorRepository.findById(id).get();
    }
    public void addProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
    }
    public void deleteProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
}
