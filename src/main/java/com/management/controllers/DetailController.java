package com.management.controllers;

import com.management.entities.DetailOrdonnance;
import com.management.entities.Laboratoire;
import com.management.entities.Medicament;
import com.management.entities.Ordonnance;
import com.management.services.DetailService;
import com.management.services.MedicamentService;
import com.management.services.OrdonnanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
public class DetailController {

   @Autowired
   DetailService detailService;
    @Autowired
    MedicamentService medicamentService;
    @Autowired
    OrdonnanceService ordonnanceService;

    @RequestMapping("/createDetail")
    public String createdOrdonnance(@RequestParam("id")Long id,ModelMap modelMap) {
        List<Medicament> l= medicamentService.getAllMedicaments();
        modelMap.addAttribute("medicaments",l);
        modelMap.addAttribute("ido",id);
        return "createDetail";
    }
    @RequestMapping("/detailList")
    public String dordonnanceList(@RequestParam("id")Long id,ModelMap modelMap){
      List<DetailOrdonnance> ordonnanceController =detailService.findByOrdonnance(id);
        modelMap.addAttribute("dordonnances", ordonnanceController);
        return "dordonnanceList";
    }

    @RequestMapping("/saveDetail")
    public String saveDetailOrdonnance(@RequestParam("idord")Long idOrdonnance,@RequestParam("idMed")Long idMed,  @Valid DetailOrdonnance detailOrdonnance, BindingResult bindingResult, ModelMap modelMap) throws ParseException {
        detailOrdonnance.setMedicament(medicamentService.getMedicament(idMed));
        detailOrdonnance.setOrdonnance(ordonnanceService.getOrdonnance(idOrdonnance));
        detailService.saveDetailOrdonnance(detailOrdonnance);
        return "redirect:/ordonnanceList";
    }
}
