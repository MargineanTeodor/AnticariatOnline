package com.projects.site.controller;

import com.projects.site.DTO.CarteDTO;
import com.projects.site.DTO.UserDTO;
import com.projects.site.service.ServiceCarte;
import com.projects.site.service.ServiceMasterUserCarte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carte")
public class CarteController {
    @Autowired
    private ServiceMasterUserCarte serviceMasterUserCarte;
    @Autowired
    private ServiceCarte serviceCarte;

    public CarteController(ServiceMasterUserCarte serviceMasterUserCarte, ServiceCarte serviceCarte) {
        this.serviceMasterUserCarte = serviceMasterUserCarte;
        this.serviceCarte = serviceCarte;
    }

    @GetMapping("/findByName")
    public ResponseEntity getBookByName(@RequestParam String name)
    {
        CarteDTO carte = serviceCarte.findFirstCarteByAutor(name);
        return ResponseEntity.status(HttpStatus.OK).body(carte);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public void delete(@RequestParam Long Id)
    {
        serviceMasterUserCarte.deleteCarte(Id);
    }
    @RequestMapping(value = "/allNume", method = RequestMethod.GET)
    public List<CarteDTO> getallNume(@RequestParam String nume)
    {
        return serviceCarte.findCarteByName(nume);
    }
    @RequestMapping(value = "/allAutor", method = RequestMethod.GET)
    public List<CarteDTO> getallAutor(@RequestParam String nume)
    {
        return serviceCarte.findCarteByAutor(nume);
    }
    @RequestMapping(value = "/oneNume", method = RequestMethod.GET)
    public CarteDTO getOneNume(@RequestParam String nume)
    {
        return serviceCarte.findFirstCarteByName(nume);
    }
    @RequestMapping(value = "/oneAutor", method = RequestMethod.GET)
    public CarteDTO getOneAutor(@RequestParam String nume)
    {
        return serviceCarte.findFirstCarteByAutor(nume);
    }
    @RequestMapping(value="/setStare", method = RequestMethod.PUT)
    public void setStare(@RequestParam Long id, int stare )
    {
        serviceCarte.updateStare(stare, id);
    }
    @RequestMapping(value="/setPret", method = RequestMethod.PUT)
    public void setPret(@RequestParam Long id, int stare )
    {
        serviceCarte.updatePret(stare, id);
    }
    @RequestMapping(value ="/createCarte", method = RequestMethod.PUT)
    public void createCarte(@RequestParam UserDTO user, String nume, int pret, int nrPag, int stare, String autor)
    {
        serviceMasterUserCarte.addCarte(user,nume,pret,nrPag,stare,autor);
    }
}
