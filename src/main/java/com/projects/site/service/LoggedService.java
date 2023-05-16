package com.projects.site.service;

import com.projects.site.DTO.LoggedDTO;
import com.projects.site.mapper.LoggedMapper;
import com.projects.site.model.Logged;
import com.projects.site.repository.CarteRepository;
import com.projects.site.repository.LoggedRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class LoggedService {
    private final LoggedRepository loggedRepository;
    private final LoggedMapper loggedMapper;

    public LoggedService(LoggedRepository loggedRepository, LoggedMapper loggedMapper) {
        this.loggedRepository = loggedRepository;
        this.loggedMapper = loggedMapper;
    }

    public void login(Long userID)
    {
        Logged x = new Logged();
        x.setAction("Login");
        x.setUserID(userID);
        this.loggedRepository.save(x);
    }
    public void logout(Long userID)
    {
        Logged x = new Logged();
        x.setAction("Logout");
        x.setUserID(userID);
        this.loggedRepository.save(x);
    }

    public List<LoggedDTO> getALl() {
        List<Logged> x = loggedRepository.findAll();
        List<LoggedDTO> y = new ArrayList<>();
        for( Logged e : x )
        {
            y.add(LoggedMapper.mapModelToDto(e));
        }
        return y;
    }
    public void saveUserToXML(Long id) {
        Optional<Logged> user = loggedRepository.findById(id);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Logged.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(user.get(), new File("Logged" + ".xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
