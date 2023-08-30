package com.example.springbootexam.service;

import com.example.springbootexam.model.Promo;
import com.example.springbootexam.model.User;
import com.example.springbootexam.repository.PromoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class PromoService {
    private final PromoDAO promoDAO;
    @Autowired
    public PromoService(PromoDAO promoDAO){
        this.promoDAO=promoDAO;
    }
    public Promo createPromo(Promo promo){
        return promoDAO.createPromo(promo);
    }
    public List<Promo> PromoList(){
        return promoDAO.allPromo();
    }
    public Promo Promonumber(int promoid){
        return promoDAO.searchPromo(promoid);
    }
    public Promo Promocategory(String category){
        return promoDAO.searchcategorypromo(category);
    }
    public Optional<Promo> deletePromo(int promoid){
        System.out.println(promoDAO.deletePromo(promoid));
        return null;
    }
    public Promo UpdateDatePromo(Date newExpiration, Date expiration){
        return  promoDAO.updatePromo(newExpiration,expiration);
    }
}
