package com.projects.site.controller;

import com.projects.site.service.ServiceMasterUserCarte;
import com.projects.site.service.ServiceUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {
    private ServiceUser serviceUser;
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
}
