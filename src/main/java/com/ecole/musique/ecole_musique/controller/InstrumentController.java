package com.ecole.musique.ecole_musique.controller;

import com.ecole.musique.ecole_musique.model.Instrument;
import com.ecole.musique.ecole_musique.service.InstrumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instruments")
public class InstrumentController {

    private final InstrumentService instrumentService;

    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping
    public String listInstruments(
            @RequestParam(required = false) String famille,
            @RequestParam(required = false) Boolean disponibilite,
            Model model) {
        model.addAttribute("instruments", instrumentService.filter(famille, disponibilite));
        model.addAttribute("famille", famille);
        model.addAttribute("disponibilite", disponibilite);
        return "instruments/list";
    }

    @GetMapping("/new")
    public String newInstrumentForm(Model model) {
        model.addAttribute("instrument", new Instrument());
        return "instruments/form";
    }

    @PostMapping("/save")
    public String saveInstrument(@ModelAttribute Instrument instrument) {
        instrumentService.save(instrument);
        return "redirect:/instruments";
    }

    @GetMapping("/edit/{id}")
    public String editInstrumentForm(@PathVariable Long id, Model model) {
        instrumentService.findById(id).ifPresent(instrument -> model.addAttribute("instrument", instrument));
        return "instruments/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteInstrument(@PathVariable Long id) {
        instrumentService.deleteById(id);
        return "redirect:/instruments";
    }
}
