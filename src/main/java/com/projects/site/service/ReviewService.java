package com.projects.site.service;

import com.projects.site.DTO.LoggedDTO;
import com.projects.site.DTO.ReviewDTO;
import com.projects.site.mapper.LoggedMapper;
import com.projects.site.mapper.ReviewMapper;
import com.projects.site.model.Logged;
import com.projects.site.model.Review;
import com.projects.site.repository.LoggedRepository;
import com.projects.site.repository.ReviewRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDTO> getallReviews(long id)
    {
        List<Review> list=this.reviewRepository.findAllByIdCarte(id);
        List<ReviewDTO> list2= new ArrayList<>();
        for (Review e: list ) {
            list2.add(ReviewMapper.mapModelToDto(e));
        }
        return list2;
    }
    public void addReview(long id,String string)
    {
        Review x = new Review();
        x.setReview(string);
        x.setIdCarte(id);
        this.reviewRepository.save(x);
    }
}
