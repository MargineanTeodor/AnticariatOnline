package com.projects.site.service;

import com.projects.site.model.Carte;
import com.projects.site.model.User;
import com.projects.site.repository.CarteRepository;
import com.projects.site.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Service {

    private CarteRepository carteRepository;
    private UserRepository userRepository;

    public Service(CarteRepository carteRepository, UserRepository userRepository) {
        this.carteRepository = carteRepository;
        this.userRepository = userRepository;
    }

    // register
    public void addUser(String name, String passw, Boolean admin)
    {
        User x =new User();
        x.setPassw(passw);
        x.setName(name);
        x.setAdmin(admin);
        userRepository.save(x);
    }

    //admin sa staerga contul
    public void deleteUser(Long id,User user)
    {
        try{
            if(user.getAdmin()) {
                User x = userRepository.findFirstById(id);
                if (x.getCarteList() != null)
                    for (Carte carte : x.getCarteList()) {
                        deleteCarte(carte.getId());
                    }
                userRepository.delete(x);
            }
        }
        catch(Exception e)
        {
            System.out.println("Nu este admin");
        }
    }
    // stergere anunt
    public void deleteCarte(Long id )
    {
        Carte x = carteRepository.findFirstById(id);
        User user = x.getUser();
        List<Carte> list = user.getCarteList();
        list.remove(x);
        user.setCarteList(list);
        userRepository.save(user);
        carteRepository.delete(x);
    }
    // adaugare anunt
    public void addCarte(User user, String name, int pret, int nrPag, int Stare,String autor)
    {
        Carte x = new Carte();
        x.setUser(user);
        x.setPret(pret);
        x.setStare(nrPag);
        x.setNrPag(Stare);
        x.setName(name);
        x.setAutor(autor);
        carteRepository.save(x);
        List<Carte> x2= user.getCarteList();
        x2.add(x);
        user.setCarteList(x2);
        userRepository.save(user);
    }
    // cautare user dupa nume
    public User findUserByName(String name)
    {
        return userRepository.findFirstByName(name);
    }
    // cautare carte dupa nume
    public List<Carte> findCarteByName(String name) {
        List<Carte> carti = carteRepository.findAllByName(name);
        return carti;
    }
    //cautare carte dupa autor
    public List<Carte> findCarteByAutor(String autor)
    {
        return carteRepository.findAllByAutor(autor);
    }

    // update la pret
    public void updatePret(int pret, Long id)
    {
        Carte x= new Carte();
        x = carteRepository.findFirstById(id);
            x.setPret(pret);
            carteRepository.save(x);
    }
    // schimbare parola
    public void updateParola(String passw, Long id)
    {
        User x= userRepository.findFirstById(id);
        x.setPassw(passw);
        userRepository.save(x);
    }
    // update la stare
    public void updateStare(int stare, Long id)
    {
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
