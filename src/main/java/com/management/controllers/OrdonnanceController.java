package com.management.controllers;


import com.management.entities.Client;
import com.management.entities.Medicament;
import com.management.entities.Ordonnance;

import com.management.services.ClientService;
import com.management.services.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class OrdonnanceController {
    @Autowired
    OrdonnanceService ordonnanceService;
    @Autowired
    ClientService clientService;

    @RequestMapping("/ordonnanceList")
    public String ordonnanceList(ModelMap modelMap){
        List<Ordonnance> ordonnanceController =ordonnanceService.getAllOrdonnances();
        modelMap.addAttribute("ordonnances", ordonnanceController);
        return "ordonnanceList";
    }

    @RequestMapping("/CreateOrdonnance")
    public String createOrdonnance(ModelMap modelMap) {

        List<Client> l= clientService.getAllClients();
        modelMap.addAttribute("clients",l);

        return "CreateOrdonance";
    }

    @RequestMapping("/saveOrdonnance")
    public String saveOrdonnance(@ModelAttribute("ordonnance") Ordonnance ordonnance, @RequestParam("idClient")long idClient){
        ordonnance.setClient(clientService.getClient(idClient));
        ordonnanceService.saveOrdonnance(ordonnance);
        return "CreateOrdonance";
    }

}
