package com.projects.site.repository;

import com.projects.site.model.Carte;
import com.projects.site.model.Logged;
import com.projects.site.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggedRepository extends JpaRepository<Logged,Long> {

}
