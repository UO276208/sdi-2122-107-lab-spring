package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Profesor;
import com.uniovi.notaneitor.services.MarksService;
import com.uniovi.notaneitor.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfesorController {
    @Autowired //Inyectar el servicio
    private ProfesorService profesorService;

    @RequestMapping("/profesor/list")
    public String getList(Model model) {
        model.addAttribute("markList", profesorService.getProfesors());
        return "Getting List" + profesorService.getProfesors().toString();
    }
    @RequestMapping(value = "/profesor/add", method = RequestMethod.POST)
    public String setProfesor(@ModelAttribute Profesor profesor) {
        profesorService.addProfesor(profesor);
        return "Adding profesor";
    }

    @RequestMapping("/profesor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("profesor", profesorService.getProfesor(id));
        return "Getting Details " + profesorService.getProfesor(id);
    }

    @RequestMapping("/profesor/delete/{id}")
    public String deleteProfesor(@PathVariable Long id) {
        profesorService.deleteProfesor(id);
        return "Deleted profesor " + id;
    }

    @RequestMapping(value = "/profesor/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("profesor", profesorService.getProfesor(id));
        return "profesor/edit";
    }

    @RequestMapping(value="/profesor/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Profesor profesor, @PathVariable Long id){
        profesor.setId(id);
        profesorService.addProfesor(profesor);
        return "Profesor edit "+id;
    }
}
