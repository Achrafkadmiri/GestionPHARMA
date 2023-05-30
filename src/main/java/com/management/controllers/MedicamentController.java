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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MedicamentController {
    @Autowired
    MedicamentService medicamentService;
    @Autowired
    LaboratoireService laboratoireService;



    @RequestMapping("/createMedicament")
    public String createMedicament(ModelMap modelMap) {
        List<Laboratoire> l= laboratoireService.getAllLaboratoires();
        modelMap.addAttribute("laboratoires",l);
        return "createMedicament";
    }

    @RequestMapping("/medicamentList")
    public String medicamentList(ModelMap modelMap) throws ParseException {
        List<Medicament> medicaments= medicamentService.getAllMedicaments();
        modelMap.addAttribute("medicaments",medicaments);
        return "medicamentList";
    }
    @RequestMapping("/saveMedicament")
    public String saveMedicament(@RequestParam("idLab")Long idLab,  @Valid Medicament medicament, BindingResult bindingResult,ModelMap modelMap) throws ParseException {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("msg", "les informations sont invalide");
            return "/createMedicament";
        }
        medicament.setFournisseur(laboratoireService.getLaboratoire(idLab));
        medicamentService.saveMedicament(medicament);
        return "redirect:/createMedicament";
    }
    @RequestMapping("/updateMedicament")
    public String updateMedicament(@ModelAttribute("Medicament") Medicament medicament, @RequestParam("idLab")long idLab,ModelMap modelMap) throws ParseException {
        medicament.setFournisseur(laboratoireService.getLaboratoire(idLab));
        medicamentService.updateMedicament(medicament);
        return "redirect:/medicamentList";
    }
    @RequestMapping("/showMedicament")
    public String showMedicament(@RequestParam("id")Long id,ModelMap modelMap) throws ParseException {
        Medicament m= medicamentService.getMedicament(id);
        List<Laboratoire> l= laboratoireService.getAllLaboratoires();
        modelMap.addAttribute("medicament",m);
        modelMap.addAttribute("laboratoires",l);
        return "showMedicament";
    }
    @RequestMapping("/deleteMedicament")
    public String deleteMedicament(@RequestParam("id")Long id) throws ParseException {
        medicamentService.deleteMedicamentById(id);
        return "redirect:/medicamentList";
    }
}
