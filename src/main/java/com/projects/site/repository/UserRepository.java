package com.projects.site.repository;

import com.projects.site.model.Carte;
import com.projects.site.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByName(String name);
    User findFirstById(Long id);

    List<User> findAllByLoged(Boolean loged);
    List<User> findAllByAdmin(Boolean admin);
}
