package com.example.springbootexam.model;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Review {
    private int reviewId;
    private Client client;
    private Product product;
    private int rating;
    private String comment;
}
