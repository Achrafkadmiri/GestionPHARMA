package com.management.controllers;

import com.management.entities.Laboratoire;
import com.management.entities.Medicament;
import com.management.services.LaboratoireService;
import com.management.services.MedicamentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
public class LaboController {

    @Autowired
    LaboratoireService laboratoireService;


    @RequestMapping("/createLab")
    public String createLab() {
        return "createLab";
    }

    @RequestMapping("/laboratoireList")
    public String laboratoireList(ModelMap modelMap) throws ParseException {
        List<Laboratoire> laboratoires = laboratoireService.getAllLaboratoires();
        modelMap.addAttribute("laboratoires", laboratoires);
        return "laboratoireList";
    }

    @RequestMapping("/saveLaboratoire")
    public String saveLaboratoire(@Valid Laboratoire laboratoire, BindingResult bindingResult, ModelMap modelMap) throws ParseException {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("msg", "les informations sont invalide");
            return "createLab";
        }
        laboratoireService.saveLaboratoire(laboratoire);
        return "redirect:/laboratoireList";
    }

    @RequestMapping("/updateLaboratoire")
    public String updateLaboratoire(@ModelAttribute("Medicament") Laboratoire laboratoire) throws ParseException {
        laboratoireService.updateLaboratoire(laboratoire);

        return "redirect:/laboratoireList";
    }

    @RequestMapping("/showLaboratoire")
    public String showLaboratoire(@RequestParam("id") Long id, ModelMap modelMap) throws ParseException {
        Laboratoire m = laboratoireService.getLaboratoire(id);
        modelMap.addAttribute("laboratoire", m);
        return "showLaboratoire";
    }

    @RequestMapping("/deleteLaboratoire")
    public String deleteLaboratoire(@RequestParam("id") Long id, ModelMap modelMap) throws ParseException {
        laboratoireService.deleteLaboratoireById(id);
        return "redirect:/laboratoireList";
    }
}
