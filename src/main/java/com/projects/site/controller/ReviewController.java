package com.projects.site.controller;

import com.projects.site.DTO.LoggedDTO;
import com.projects.site.DTO.ReviewDTO;
import com.projects.site.service.LoggedService;
import com.projects.site.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<ReviewDTO> all(@RequestParam long id){
        return reviewService.getallReviews(id);

    }
    @RequestMapping(value= "/add", method = RequestMethod.PUT)
    public void addReview(@RequestParam long id, String string)
    {
        reviewService.addReview(id,string);
    }

}
