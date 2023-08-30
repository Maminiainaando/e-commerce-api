package com.example.springbootexam.repository;

import com.example.springbootexam.model.Review;

import java.util.List;

public interface ReviewDAOInterface {
    Review addReview(Review review);
    List<Review> findAllReview();
    Review updatecomment(String newcomment, String comment);
    Review updaterating(int newrate, int rate);
    boolean deleteReview(int reviewid);
    Review findAllComment();
}
