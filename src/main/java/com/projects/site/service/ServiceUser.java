package com.projects.site.service;

import com.projects.site.model.User;
import com.projects.site.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {
    private UserRepository userRepository;
    public ServiceUser(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    public void addUser(String name, String passw, Boolean admin) {
        User x =new User();
        x.setPassw(passw);
        x.setName(name);
        x.setAdmin(admin);
        userRepository.save(x);
    }
    public User findUserByName(String name)
    {
        return userRepository.findFirstByName(name);
    }
    public void updateParola(String passw, Long id) {
        User x= userRepository.findFirstById(id);
        x.setPassw(passw);
        userRepository.save(x);
    }
}
