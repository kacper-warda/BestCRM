package com.example.bestcrmintheunivers.controllers;

import com.example.bestcrmintheunivers.entities.Client;
import com.example.bestcrmintheunivers.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("clients", this.clientRepository.findAll());
        return "client/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("client", new Client());
        return "client/add";
    }

    @GetMapping("/save")
    public String save() {
        Client client = new Client();
        client.setName("Logintegra");
        client.setAddress("Lęborska 3b");
        client.setCountry("Poland");
        client.setEmail("info@logintegra.com");
        this.clientRepository.save(client);
        return "redirect:/";
    }
}
