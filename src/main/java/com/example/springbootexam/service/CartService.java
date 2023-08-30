package com.example.springbootexam.service;

import com.example.springbootexam.model.Cart;
import com.example.springbootexam.repository.CartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartDAO cartDAO;
    @Autowired
    public CartService(CartDAO cartDAO){
        this.cartDAO=cartDAO;
    }
    public List<Cart> CartList(){
        return cartDAO.findAll();
    }
    public Cart create(Cart cart){
        return cartDAO.insert(cart);
    }
    public Optional<Cart> searchId(int cartid){
        return cartDAO.searchcartById(cartid);
    }
    public Optional<Cart> searchUserCart(String usercart){
        return cartDAO.searchcartUsercart(usercart);
    }
    public Optional<Cart> searchCartType(String typecart){
        return cartDAO.searchcartType(typecart);
    }
    public Optional<Cart> updateCartType(String newtype,String typecart){
        return cartDAO.updateCartType(newtype,typecart);
    }
    public Optional<Cart> updateUserCart(String newuser,String usercart){
        return cartDAO.updateCartUserCart(newuser,usercart);
    }
    public Optional<Cart> deleteCartType(String typecart){
        return cartDAO.deleteByType(typecart);
    }
    public Optional<Cart> deleteUserCart(String usercart){
        return cartDAO.deleteByUser(usercart);
    }
}
