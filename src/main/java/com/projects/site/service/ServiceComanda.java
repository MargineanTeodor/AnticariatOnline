package com.projects.site.service;

import com.projects.site.DTO.ComandaDTO;
import com.projects.site.DTO.UserDTO;
import com.projects.site.mapper.ComandaMapper;
import com.projects.site.mapper.UserMapper;
import com.projects.site.model.Carte;
import com.projects.site.model.Comanda;
import com.projects.site.model.User;
import com.projects.site.repository.ComandaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceComanda {
    private ComandaRepository comandaRepository;
    private ComandaMapper comnadaMapper;
    public ServiceComanda(ComandaRepository comandaRepository2, ComandaMapper comnadaMapper)
    {
        this.comandaRepository= comandaRepository2;
        this.comnadaMapper= comnadaMapper;
    }
    public void createComanda(UserDTO user,List<Carte> lista)
    {
        Comanda comanda = new Comanda();
        User x= UserMapper.mapDtoToModel(user);
        comanda.setUser(x);
        comanda.setPlatita(Boolean.FALSE);
        int sum=0;
        for (Carte x2 :lista) {
            sum+=x2.getPret();
        }
        comanda.setPret(sum);
        System.out.println(sum);
        comanda.setCarteList(lista);
        comandaRepository.save(comanda);
    }
    public ComandaDTO ffindFirstById(int x)
    {
        Comanda x2= this.comandaRepository.findFirstById(x);
        return ComandaMapper.mapModelToDto(x2);
    }
    public void updatePlata(int id)
    {
        ComandaDTO x= ffindFirstById(id);
        Comanda x2= ComandaMapper.mapDtoToModel(x);
        x2.setPlatita(Boolean.TRUE);
        comandaRepository.save(x2);
    }
}
