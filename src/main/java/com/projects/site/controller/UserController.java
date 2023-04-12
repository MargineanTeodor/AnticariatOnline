package com.projects.site.controller;

import com.projects.site.service.ServiceUser;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class UserController {
    private ServiceUser serviceUser;
    public UserController(ServiceUser x)
    {
        this.serviceUser= serviceUser;
    }
}
