package com.projects.site.controller;

import com.projects.site.DTO.CarteDTO;
import com.projects.site.DTO.UserDTO;
import com.projects.site.model.Carte;
import com.projects.site.service.ServiceCarte;
import com.projects.site.service.ServiceMasterUserCarte;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200/")
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

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<CarteDTO> all(){
        return serviceCarte.findAll2();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        serviceMasterUserCarte.deleteCarte(id);
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
    @RequestMapping(value="/setStare", method = RequestMethod.POST)
    public void setStare(@RequestParam Long id, int stare )
    {
        serviceCarte.updateStare(stare, id);
    }
    @RequestMapping(value="/setPret", method = RequestMethod.POST)
    public void setPret(@RequestParam Long id, int stare )
    {
        serviceCarte.updatePret(stare, id);
    }
    @RequestMapping(value ="/createCarte", method = RequestMethod.POST)
    public void createCarte( @RequestParam Long userId, String nume, Integer pret, Integer nrPag, Integer stare, String autor)
    {
        serviceMasterUserCarte.addCarte(userId,nume,pret,nrPag,stare,autor);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarteDTO> getCarteById(@PathVariable Long id)
    {
        CarteDTO carte= serviceCarte.findFirstCarteById(id);
        return ResponseEntity.ok(carte);
    }
}
