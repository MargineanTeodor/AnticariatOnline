package com.projects.site.service;

import com.projects.site.model.Carte;
import com.projects.site.repository.CarteRepository;

import java.util.List;

public class ServiceCarte {
    private CarteRepository carteRepository;
    public ServiceCarte(CarteRepository carteRepository)
    {
        this.carteRepository= carteRepository;
    }

    public List<Carte> findCarteByName(String name) {
        List<Carte> carti = carteRepository.findAllByName(name);
        return carti;
    }
    public List<Carte> findCarteByAutor(String autor)
    {
        return carteRepository.findAllByAutor(autor);
    }
    public void updatePret(int pret, Long id) {
        Carte x= new Carte();
        x = carteRepository.findFirstById(id);
        x.setPret(pret);
        carteRepository.save(x);
    }
    public void updateStare(int stare, Long id) {
        Carte x = carteRepository.findFirstById(id);
        x.setStare(stare);
        carteRepository.save(x);
    }
    public Carte findFirstCarteByName(String nume) {
        return carteRepository.findFirstByName(nume);
    }
    public Carte findFirstCarteByAutor(String autor) {
        return carteRepository.findFirstByAutor(autor);
    }
}
