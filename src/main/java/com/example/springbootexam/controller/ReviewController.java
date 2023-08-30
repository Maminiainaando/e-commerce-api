package com.example.springbootexam.controller;

import com.example.springbootexam.model.Client;
import com.example.springbootexam.model.Review;
import com.example.springbootexam.repository.ReviewDAO;
import com.example.springbootexam.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/reviews")
    public Review insertReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewService.ReviewList();
    }

    @GetMapping("/reviews/comment/{comment}")
    public Optional<Review> reviewByComment() {  // Correction de la méthode, il manquait le chemin d'accès
        return Optional.ofNullable(reviewService.ReviewComment());
    }

    @PutMapping("/reviews/rate/{rate}")
    public Review updateReviewRate(@PathVariable int rate, @RequestBody int newRate) {
        return reviewService.ChangeRate(newRate, rate);
    }

    @PutMapping("/reviews/comment/{comment}")
    public Review updateReviewComment(@PathVariable String comment, @RequestBody String newComment) {
        return reviewService.ChangeComment(newComment, comment);
    }

    @DeleteMapping("/reviews/{reviewid}")
    public Optional<Review> deleteReview(@PathVariable int reviewid) {
        return reviewService.deleteReview(reviewid);
    }
}
/*
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService){
        this.reviewService=reviewService;
    }
    @PostMapping("/review")
    public Review insertCLient(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @GetMapping("/review")
    public List<Review> getAllClient() {
        return reviewService.ReviewList();
    }

    @GetMapping("/review/{comment}")
    public Optional<Review> CartByPhonenumber() {
        return Optional.ofNullable(reviewService.ReviewComment());
    }
    @PutMapping("/review/{name}")

    public Review UpdateRating(@PathVariable int newrate, int rate) {
        return reviewService.ChangeRate(newrate, rate);
    }
    @PutMapping("/review/{phonenumber}")
    public Review UpdateComment(@PathVariable String newcomment, String comment) {
        return reviewService.ChangeComment(newcomment, comment);
    }
    @DeleteMapping("/review/{reviewid}")
    public  Optional<Review> DeleteReview(@PathVariable int clientid){
        return reviewService.deleteReview(clientid);
    }
}*/
