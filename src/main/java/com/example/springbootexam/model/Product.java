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
public class Product{
    private int productId;
    private String productName;
    private float price;
    private int stockQuantity;
    private String category;
    private String categoryDescription;
}
