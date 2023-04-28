package com.projects.site.controller;

import com.projects.site.DTO.UserDTO;
import com.projects.site.service.ServiceMasterUserCarte;
import com.projects.site.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    private ServiceMasterUserCarte serviceMasterUserCarte;
    public UserController(ServiceUser x,ServiceMasterUserCarte y)
    {
        this.serviceUser= x;
        this.serviceMasterUserCarte=y;
    }
    @RequestMapping(value ="/delete",method = RequestMethod.DELETE)
    public void delete(@RequestParam Long Id)
    {
        serviceMasterUserCarte.deleteUser(Id);
    }
    @RequestMapping(value ="/login")
    public Boolean login(@RequestParam String nume, String passw)
    {
        Boolean val = serviceUser.login(nume, passw);
        return val;
    }
    @RequestMapping(value = "/nume", method = RequestMethod.GET)
    public UserDTO getNume(@RequestParam String nume)
    {
        return serviceUser.findUserByName(nume);
    }
    @RequestMapping(value="/adduser",method = RequestMethod.PUT)
    public void addUser(@RequestParam String nume,String parola)
    {
        serviceUser.addUser(nume,parola,Boolean.FALSE);
    }
    @RequestMapping(value="/findUser",method = RequestMethod.GET)
    public UserDTO findUser(@RequestParam String nume)
    {
        return serviceUser.findUserByName(nume);
    }
}
