package com.projects.site.mapper;

import com.projects.site.DTO.CarteDTO;
import com.projects.site.DTO.ReviewDTO;
import com.projects.site.model.Carte;
import com.projects.site.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public static ReviewDTO mapModelToDto(Review review)
    {
        ReviewDTO x= new ReviewDTO();
        x.setReview(review.getReview());
        x.setIdCarte(review.getIdCarte());
        return x;
    }
    public static Review mapDtoToModel(ReviewDTO review)
    {
        Review x= new Review();
        x.setReview(review.getReview());
        x.setIdCarte(review.getIdCarte());
        return x;
    }

}
