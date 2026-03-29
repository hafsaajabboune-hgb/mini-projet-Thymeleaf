package com.ecole.musique.ecole_musique.controller;

import com.ecole.musique.ecole_musique.model.Cours;
import com.ecole.musique.ecole_musique.service.CoursService;
import com.ecole.musique.ecole_musique.service.ProfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cours")
public class CoursController {

    private final CoursService coursService;
    private final ProfService profService;

    public CoursController(CoursService coursService, ProfService profService) {
        this.coursService = coursService;
        this.profService = profService;
    }

    @GetMapping
    public String listCours(
            @RequestParam(required = false) String niveau,
            @RequestParam(required = false) String jour,
            Model model) {
        model.addAttribute("cours", coursService.filter(niveau, jour));
        model.addAttribute("niveau", niveau);
        model.addAttribute("jour", jour);
        return "cours/list";
    }

    @GetMapping("/new")
    public String newCoursForm(Model model) {
        model.addAttribute("cours", new Cours());
        model.addAttribute("profs", profService.findAll());
        return "cours/form";
    }

    @PostMapping("/save")
    public String saveCours(@ModelAttribute Cours cours) {
        coursService.save(cours);
        return "redirect:/cours";
    }

    @GetMapping("/edit/{id}")
    public String editCoursForm(@PathVariable Long id, Model model) {
        coursService.findById(id).ifPresent(cours -> {
            model.addAttribute("cours", cours);
            model.addAttribute("profs", profService.findAll());
        });
        return "cours/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCours(@PathVariable Long id) {
        coursService.deleteById(id);
        return "redirect:/cours";
    }
}
