package com.projects.site.controller;

import com.projects.site.DTO.ComandaDTO;
import com.projects.site.DTO.UserDTO;
import com.projects.site.model.Carte;
import com.projects.site.service.ServiceComanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/comanda")
public class ComandaController {
    @Autowired
    private ServiceComanda serviceComanda;

    public ComandaController(ServiceComanda serviceComanda) {
        this.serviceComanda = serviceComanda;
    }
    @RequestMapping(value="/all", method= RequestMethod.GET)
    public List<ComandaDTO> getAll()
    {
        return serviceComanda.getAll();
    }

    @RequestMapping(value="/createComanda", method = RequestMethod.POST)
    public void createComanda(@RequestParam int pret )
    {
        serviceComanda.createComanda(pret);
    }
    @RequestMapping(value = "/findComanda",method = RequestMethod.GET)
    public ComandaDTO findComanda(@RequestParam int id)
    {
        return serviceComanda.ffindFirstById(id);
    }
    @RequestMapping(value= "/updatePlata", method = RequestMethod.POST)
    public void updatePlata(@RequestParam int id)
    {
        serviceComanda.updatePlata(id);
    }
}
