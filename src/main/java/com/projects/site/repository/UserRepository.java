package com.projects.site.repository;

import com.projects.site.model.Carte;
import com.projects.site.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByName(String name);
    User findFirstById(Long id);


}
