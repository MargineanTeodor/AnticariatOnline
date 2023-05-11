package com.projects.site.controller;

import com.projects.site.DTO.UserDTO;
import com.projects.site.service.LoggedService;
import com.projects.site.service.ServiceMasterUserCarte;
import com.projects.site.service.ServiceUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    private LoggedService loggedService;
    @Autowired
    private ServiceMasterUserCarte serviceMasterUserCarte;
    public UserController(ServiceUser x,ServiceMasterUserCarte y, LoggedService loggedService)
    {
        this.loggedService= loggedService;
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
    public void addUser(@Valid @RequestParam String nume, String parola)
    {
        serviceUser.addUser(nume,parola,Boolean.FALSE);
    }
    @RequestMapping(value="/findUser",method = RequestMethod.GET)
    public UserDTO findUser(@RequestParam String nume)
    {
        return serviceUser.findUserByName(nume);
    }
    @RequestMapping(value="/loggedusers",method = RequestMethod.GET)
    public List<UserDTO> findUSers()
    {
        return serviceUser.findUserByLogin(Boolean.TRUE);
    }
    @RequestMapping(value= "/logged",method = RequestMethod.PUT)
    public void setLoged(@RequestParam Long id)
    {
        loggedService.login(id);
        serviceUser.setLogged(id);
    }
    @RequestMapping(value= "/logout", method = RequestMethod.PUT)
    public void setLoged2(@RequestParam Long id)
    {
        loggedService.logout(id);
        serviceUser.setLogged2(id);
    }
    @RequestMapping(value="/swapPassw",method = RequestMethod.PUT)
    public void changePassw(@RequestParam Long id, String passw)
    {
        serviceUser.changePassw(id,passw);
    }
    @RequestMapping(value = "/notAdmins",method = RequestMethod.GET)
    public List<UserDTO> getNonAdmins()
    {
        return serviceUser.findNonAdmins(Boolean.FALSE);
    }
    @RequestMapping(value="/firstId",method = RequestMethod.GET)
    public UserDTO getUserById(@RequestParam Long id)
    {
        return serviceUser.getUserById(id);
    }
}
