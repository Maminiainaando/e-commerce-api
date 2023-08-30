package com.example.springbootexam.repository;

import com.example.springbootexam.model.Promo;
import com.example.springbootexam.model.User;

import java.util.Date;
import java.util.List;

public interface PromoDAOInterface {
    Promo createPromo(Promo promo);
    Promo searchPromo(int promoid);
    Promo updatePromo(Date newExpiration, Date Expiration);
    boolean deletePromo(int promoid);
   List<Promo> allPromo();
    Promo searchcategorypromo(String category);
}
