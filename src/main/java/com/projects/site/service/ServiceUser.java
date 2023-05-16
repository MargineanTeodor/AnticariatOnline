package com.projects.site.service;

import com.projects.site.DTO.UserDTO;
import com.projects.site.mapper.UserMapper;
import com.projects.site.model.Carte;
import com.projects.site.model.Comanda;
import com.projects.site.model.User;
import com.projects.site.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
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
        x.setPassw(criptare(passw));
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
        if(user.getPassw().equals(criptare(passw)))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
    public UserDTO findUserByName(String name)
    {
        return UserMapper.mapModelToDto(userRepository.findFirstByName(name));
    }
    public void updateParola(String passw, Long id) {
        User x= userRepository.findFirstById(id);
        x.setPassw(criptare(passw));
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
    private static byte[] getKey() {
        return new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};
    }
    private static String criptare(String parola)
    {
        try {
        // Get the key to use for encrypting the data
            byte[] key = getKey();
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(parola.getBytes());
            return new String(encryptedBytes);
    }   catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }
    public UserDTO getUserById(Long id) {
        User x = userRepository.findFirstById(id);
        return UserMapper.mapModelToDto(x);
    }
}
