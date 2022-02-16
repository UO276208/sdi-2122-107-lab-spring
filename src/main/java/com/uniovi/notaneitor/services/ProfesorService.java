package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Profesor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfesorService {
    private List<Profesor> profesors = new LinkedList<>();

    @PostConstruct
    public void init() {
        profesors.add(new Profesor("adsa", "lais", "asd", "2", 4));
        profesors.add(new Profesor("erew", "lais", "asd", "4", 5));
    }
    public List<Profesor> getProfesors() {
        return profesors;
    }
    public Profesor getProfesor(Long id) {
        return profesors.stream()
                .filter(mark -> mark.getId().equals(id)).findFirst().get();
    }
    public void addProfesor(Profesor profesor) {
        if (profesor.getId() == null) {
            //profesor.setId(profesores.get(profesores.size() - 1).getId() + 1);
        }
        profesors.add(profesor);
    }
    public void deleteProfesor(Long id) {
        profesors.removeIf(profesor -> profesor.getId().equals(id));
    }
}
