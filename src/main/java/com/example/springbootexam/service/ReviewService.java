package com.example.springbootexam.service;

import com.example.springbootexam.model.Review;
import com.example.springbootexam.repository.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewDAO reviewDAO;
    @Autowired
    public ReviewService (ReviewDAO reviewDAO){
        this.reviewDAO=reviewDAO;
    }
    public Review createReview(Review review){
        return reviewDAO.addReview(review);
    }
    public List<Review> ReviewList(){
        return reviewDAO.findAllReview();
    }
    public Review ReviewComment(){
        return reviewDAO.findAllComment();
    }

    public Review ChangeComment(String newcomment,String comment){
        return  reviewDAO.updatecomment(newcomment,comment);
    }
    public Review ChangeRate(int newrate,int rate){
        return  reviewDAO.updaterating(newrate,rate);
    }
    public Optional<Review> deleteReview(int reviewid){
        System.out.println(reviewDAO.deleteReview(reviewid));
        return null;
    }
}
