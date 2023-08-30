package com.example.springbootexam.repository;

import com.example.springbootexam.model.Product;

import java.util.List;

public interface ProductDAOInterface {
    Product createProduct(Product product);
    void stockProduct();
    List<Product> findAllProduct();
    Product updateCategory(String newcategory, String category);
    Product searchcategory(String category);
    Product searchProductname(String productName);
    boolean deleteByid(int productId);
    boolean deleteByname(String productName);
}
