package com.projects.site.service;

import com.projects.site.DTO.CarteDTO;
import com.projects.site.DTO.ComandaDTO;
import com.projects.site.DTO.UserDTO;
import com.projects.site.mapper.ComandaMapper;
import com.projects.site.mapper.UserMapper;
import com.projects.site.model.Carte;
import com.projects.site.model.Comanda;
import com.projects.site.model.User;
import com.projects.site.repository.CarteRepository;
import com.projects.site.repository.ComandaRepository;
import com.projects.site.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceComanda {
    private ComandaRepository comandaRepository;
    private ComandaMapper comnadaMapper;
    private CarteRepository carteRepository;
    private UserRepository userRepository;
    public ServiceComanda(ComandaRepository comandaRepository2, ComandaMapper comnadaMapper, UserRepository userRepository, CarteRepository carteRepository)
    {
        this.comandaRepository= comandaRepository2;
        this.comnadaMapper= comnadaMapper;
        this.userRepository= userRepository;
        this.carteRepository=  carteRepository;
    }
    public void createComanda(int pret)
    {
        Comanda comanda = new Comanda();
        comanda.setPlatita(Boolean.FALSE);
        comanda.setPret(pret);
        comandaRepository.save(comanda);
    }
    public ComandaDTO ffindFirstById(int x)
    {
        Comanda x2= this.comandaRepository.findFirstById(x);
        return ComandaMapper.mapModelToDto(x2);
    }
    public void updatePlata(int id)
    {
        Comanda x2= this.comandaRepository.findFirstById(id);
        x2.setPlatita(Boolean.TRUE);
        comandaRepository.save(x2);
    }
    public List<ComandaDTO> getAll()
    {
        List<Comanda> lista1= comandaRepository.findAll();
        List<ComandaDTO> lista2= new ArrayList<ComandaDTO>();
        for (Comanda e :lista1) {
            lista2.add(ComandaMapper.mapModelToDto(e));
        }
        return lista2;
    }
}
