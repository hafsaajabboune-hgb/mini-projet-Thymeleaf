package com.ecole.musique.ecole_musique.controller;

import com.ecole.musique.ecole_musique.model.Prof;
import com.ecole.musique.ecole_musique.service.ProfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profs")
public class ProfController {

    private final ProfService profService;

    public ProfController(ProfService profService) {
        this.profService = profService;
    }

    @GetMapping
    public String listProfs(Model model) {
        model.addAttribute("profs", profService.findAll());
        return "profs/list";
    }

    @GetMapping("/new")
    public String newProfForm(Model model) {
        model.addAttribute("prof", new Prof());
        return "profs/form";
    }

    @PostMapping("/save")
    public String saveProf(@ModelAttribute Prof prof) {
        profService.save(prof);
        return "redirect:/profs";
    }

    @GetMapping("/edit/{id}")
    public String editProfForm(@PathVariable Long id, Model model) {
        profService.findById(id).ifPresent(prof -> model.addAttribute("prof", prof));
        return "profs/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProf(@PathVariable Long id) {
        profService.deleteById(id);
        return "redirect:/profs";
    }
}
