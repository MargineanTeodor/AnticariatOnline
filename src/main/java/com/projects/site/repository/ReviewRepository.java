package com.projects.site.repository;

import com.projects.site.model.Carte;
import com.projects.site.model.Review;
import com.projects.site.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review>  findAllByIdCarte(long id);
}
