package com.projects.site.service;

import com.projects.site.model.Carte;
import com.projects.site.model.User;
import com.projects.site.repository.CarteRepository;
import com.projects.site.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceMasterUserCarte {

    private CarteRepository carteRepository;
    private UserRepository userRepository;

    public ServiceMasterUserCarte(CarteRepository carteRepository, UserRepository userRepository) {
        this.carteRepository = carteRepository;
        this.userRepository = userRepository;
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
    // cautare carte dupa nume

}
