package com.example.springbootexam.repository;

import com.example.springbootexam.model.Client;
import com.example.springbootexam.model.ECommerce;
import com.example.springbootexam.model.Product;
import com.example.springbootexam.model.User;

import java.util.List;

public interface ECommerceDAOInterface {
    List<Product> listProduct();
    ECommerce listCategory();
    List<Client> listClient();
    List<User> listBoss();
}
