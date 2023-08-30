package com.example.springbootexam.model;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString


public class Promo {
    private int promoid;
    private Product product;
    private Date expirationDate;
    private String category;
}
