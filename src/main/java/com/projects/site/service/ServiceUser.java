package com.projects.site.service;

import com.projects.site.DTO.UserDTO;
import com.projects.site.mapper.UserMapper;
import com.projects.site.model.Carte;
import com.projects.site.model.Comanda;
import com.projects.site.model.User;
import com.projects.site.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        x.setLoged(false);
        x.setCarteList(new ArrayList<Carte>());
        x.setComenziList(new ArrayList<Comanda>());
        userRepository.save(x);
    }
    public Boolean login(String name, String passw)
    {
        UserDTO user = this.findUserByName(name);
        if(user.getPassw().equals(passw))
            return Boolean.TRUE;
        return Boolean.FALSE;
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

    public List<UserDTO> findUserByLogin(Boolean logged) {
        List<User> x = userRepository.findAllByLoged(logged);
        List<UserDTO> y= new ArrayList<UserDTO>();
        for(User e: x)
        {
            y.add(UserMapper.mapModelToDto(e));
        }
        return y;
    }

    public void setLogged(Long id) {
        User x = userRepository.findFirstById(id);
        x.setLoged(Boolean.TRUE);
        userRepository.save(x);

    }

    public void setLogged2(Long id) {
        User x = userRepository.findFirstById(id);
        x.setLoged(Boolean.FALSE);
        userRepository.save(x);
    }

    public void changePassw(Long id, String passw) {
        User x = userRepository.findFirstById(id);
        x.setPassw(passw);
        userRepository.save(x);
    }

    public List<UserDTO> findNonAdmins(Boolean aFalse) {
        List<User> x = userRepository.findAllByAdmin(aFalse);
        List<UserDTO> y = new ArrayList<>();
        for(User e : x )
        {
            y.add(UserMapper.mapModelToDto(e));
        }
        return y;
    }
}
