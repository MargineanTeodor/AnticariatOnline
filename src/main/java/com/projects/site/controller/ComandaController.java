package com.projects.site.controller;

import com.projects.site.DTO.ComandaDTO;
import com.projects.site.DTO.UserDTO;
import com.projects.site.model.Carte;
import com.projects.site.service.ServiceComanda;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comanda")
public class ComandaController {
    private ServiceComanda serviceComanda;

    public ComandaController(ServiceComanda serviceComanda) {
        this.serviceComanda = serviceComanda;
    }

    @RequestMapping(value ="/createComanda", method = RequestMethod.PUT)
    public void createCarte(@RequestParam UserDTO user, List<Carte> lista)
    {
        serviceComanda.createComanda(user,lista);
    }
    @RequestMapping(value = "/findComanda",method = RequestMethod.GET)
    public ComandaDTO findComanda(@RequestParam int id)
    {
        return serviceComanda.ffindFirstById(id);
    }
    @RequestMapping(value= "/updatePlata", method = RequestMethod.PUT)
    public void updatePlata(@RequestParam int id)
    {
        serviceComanda.updatePlata(id);
    }
}
