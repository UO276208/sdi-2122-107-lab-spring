package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Profesor;
import com.uniovi.notaneitor.services.MarksService;
import com.uniovi.notaneitor.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfesorController {
    @Autowired //Inyectar el servicio
    private ProfesorService profesorService;

    @RequestMapping("/professor/list")
    public String getList(Model model) {
        model.addAttribute("professorsList", profesorService.getProfesors());
        return "professor/list";
    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfesor(@ModelAttribute Profesor profesor) {
        profesorService.addProfesor(profesor);
        return "/professor/add";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("profesor", profesorService.getProfesor(id));
        return "/professor/details";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfesor(@PathVariable Long id) {
        profesorService.deleteProfesor(id);
        return "redirect:/professor/list";
    }

    @RequestMapping(value = "/professor/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("profesor", profesorService.getProfesor(id));
        return "professor/edit";
    }

    @RequestMapping(value="/professor/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Profesor profesor, @PathVariable Long id){
        profesor.setId(id);
        profesorService.addProfesor(profesor);
        return "redirect:/professor/details/"+id;
    }
}
