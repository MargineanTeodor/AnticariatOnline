package com.projects.site.repository;

import com.projects.site.model.Carte;
import com.projects.site.model.Comanda;
import com.projects.site.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends CrudRepository<Comanda,Long> {
     Comanda findFirstById(int x);
}
