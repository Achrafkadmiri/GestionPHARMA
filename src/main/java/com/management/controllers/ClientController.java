package com.management.controllers;

import ch.qos.logback.core.model.Model;
import com.management.entities.Client;
import com.management.repositories.ClientRepository;
import com.management.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;

    @RequestMapping("/createClient")
    public String createClient() {
        return "CreateClient";
    }
    @RequestMapping("/accueil")
    public String accueil() {
        return "accueil";
    }

    @RequestMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client) {
         clientService.saveClient(client);
        return "redirect:/clientList";

    }

    @RequestMapping("/clientList")
    public String clientList(ModelMap modelMap) {
        List<Client> clientController = clientService.getAllClients();
        modelMap.addAttribute("clients", clientController);
        return "ClientList";
    }



    @PostMapping("/updateClient")
    public String updateClient(@ModelAttribute("client") Client updatedClient) throws ParseException {
        // Retrieve the existing client from the service
        Client existingClient = clientService.getClient(updatedClient.getIdClient());

        // Update the existing client with the new values
        existingClient.setNomClient(updatedClient.getNomClient());
        existingClient.setPrenomClient(updatedClient.getPrenomClient());
        existingClient.setAddressClient(updatedClient.getAddressClient());
        existingClient.setTelClient(updatedClient.getTelClient());

        // Save the updated client using the service
        clientService.updateClient(existingClient);

        return "redirect:/clientList";
    }

    @RequestMapping("/showClient")
    public String showClient(@RequestParam("id")Long id, ModelMap modelMap){
        Client clientController = clientService.getClient(id);
        modelMap.addAttribute("client", clientController);
        return "showClient";
    }


    @RequestMapping("/deleteClient")
    public String deleteClient(@RequestParam("id") Long id, ModelMap modelMap) {
        clientService.deleteClientById(id);
        List<Client> clientController = clientService.getAllClients();
        modelMap.addAttribute("client", clientController);
        return "redirect:/clientList";
    }

}