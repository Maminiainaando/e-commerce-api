package com.example.springbootexam.repository;
import com.example.springbootexam.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartDAOInterface{
    Cart insert(Cart cart);
    List<Cart> findAll();
    Optional<Cart> updateCartUserCart(String newuser, String usercart);
    Optional<Cart> updateCartType(String newtype, String typecart);
    Optional<Cart> searchcartUsercart(String usercart);
    Optional<Cart> searchcartById(int cartid);
    Optional<Cart> searchcartType(String typecart);
    Optional<Cart> deleteByUser(String usercart);
    Optional<Cart> deleteByType(String typecart);
}
