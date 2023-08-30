package com.example.springbootexam.service;

import com.example.springbootexam.model.Client;
import com.example.springbootexam.model.ECommerce;
import com.example.springbootexam.model.Product;
import com.example.springbootexam.model.User;
import com.example.springbootexam.repository.ECommerceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ECommerceService {
    private final ECommerceDAO eCommerceDAO;
    @Autowired
    public ECommerceService(ECommerceDAO eCommerceDAO){
        this.eCommerceDAO=eCommerceDAO;
    }
    public List<Client> listClient(Client client){
        return eCommerceDAO.listClient();
    }
    public List<User> UserList(User user){
        return eCommerceDAO.listBoss();
    }
    public ECommerce getAllCategory(String category){
        return eCommerceDAO.listCategory();
    }
    public List<Product> productList(Product product){
        return eCommerceDAO.listProduct();
    }
}
