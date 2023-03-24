package com.projects.site.repository;

import com.projects.site.model.Carte;
import com.projects.site.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteRepository extends CrudRepository<Carte,Long> {
    List<Carte> findAllByName (String name);
    Carte findFirstById (Long id);
    void deleteAllByUser(User user);
    List<Carte> findAllByAutor(String autor);
    Carte findFirstByName(String name);
    Carte findFirstByAutor(String autor);
}
