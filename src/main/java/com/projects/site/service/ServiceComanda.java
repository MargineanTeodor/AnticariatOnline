package com.projects.site.service;

import com.projects.site.model.Carte;
import com.projects.site.model.Comanda;
import com.projects.site.model.User;
import com.projects.site.repository.ComandaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceComanda {
    private ComandaRepository comandaRepository;
    public ServiceComanda(ComandaRepository comandaRepository2)
    {
        this.comandaRepository= comandaRepository2;
    }
    public void createComanda(User user,List<Carte> lista)
    {
        Comanda comanda = new Comanda();
        comanda.setPlatita(Boolean.FALSE);
        int sum=0;
        for (Carte x :lista) {
            sum+=x.getPret();
        }
        comanda.setPret(sum);
        System.out.println(sum);
        comanda.setCarteList(lista);
        comandaRepository.save(comanda);
    }
    public Comanda ffindFirstById(int x)
    {
        return this.comandaRepository.findFirstById(x);
    }
    public void updatePlata(int id)
    {
        Comanda x=  ffindFirstById(id);
        x.setPlatita(Boolean.TRUE);
        comandaRepository.save(x);
    }
}
