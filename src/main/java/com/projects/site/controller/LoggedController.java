package com.projects.site.controller;

import com.projects.site.DTO.CarteDTO;
import com.projects.site.DTO.LoggedDTO;
import com.projects.site.service.LoggedService;
import com.projects.site.service.ServiceCarte;
import com.projects.site.service.ServiceMasterUserCarte;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/logged")
public class LoggedController {
    @Autowired
    private LoggedService loggedService;

    public LoggedController(LoggedService loggedService) {
        this.loggedService = loggedService;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<LoggedDTO> all(){
        return loggedService.getALl();
    }
    @RequestMapping(value= "/XML", method = RequestMethod.GET)
    public void generateXML(@RequestParam long id)
    {
        loggedService.saveUserToXML(id);
    }

}
