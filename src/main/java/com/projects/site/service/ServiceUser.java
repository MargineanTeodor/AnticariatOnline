package com.projects.site.service;

import com.projects.site.DTO.UserDTO;
import com.projects.site.mapper.UserMapper;
import com.projects.site.model.Carte;
import com.projects.site.model.Comanda;
import com.projects.site.model.User;
import com.projects.site.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceUser {
    private UserRepository userRepository;
    private UserMapper userMapper;
    public ServiceUser(UserRepository userRepository, UserMapper usermapper)

    {
        this.userRepository=userRepository;
        this.userMapper = usermapper;
    }
    public void addUser(String name, String passw, Boolean admin) {
        User x =new User();
        x.setPassw(passw);
        x.setName(name);
        x.setAdmin(admin);
        x.setCarteList(new ArrayList<Carte>());
        x.setComenziList(new ArrayList<Comanda>());
        userRepository.save(x);
    }
    public UserDTO findUserByName(String name)
    {
        return UserMapper.mapModelToDto(userRepository.findFirstByName(name));
    }
    public void updateParola(String passw, Long id) {
        User x= userRepository.findFirstById(id);
        x.setPassw(passw);
        userRepository.save(x);
    }
}
