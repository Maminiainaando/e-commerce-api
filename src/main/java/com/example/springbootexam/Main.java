package com.example.springbootexam;

import com.example.springbootexam.model.*;
import com.example.springbootexam.repository.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    /*List<Product> productlist=new ArrayList<>();

      Product product = new Product(1, "Nom du Produit1", 129, 50, "Catégorie 1", "Description de la catégorie 1");
      ProductDAOInterface productDAOInterface = context.getBean(ProductDAOInterface.class);
      productDAOInterface.createProduct(product);

      Client client=new Client(1,"fyh","032554435541");
      ClientDAOInterface clientDAOInterface=context.getBean(ClientDAOInterface.class);
      clientDAOInterface.insert(client);


      Cart cart=new Cart(1,"espece","antsa",client);
      CartDAOInterface cartDAOInterface=context.getBean(CartDAOInterface.class);
      cartDAOInterface.insert(cart);

      Order order=new Order(1,client,new Date(),true,productlist,13,154);
      OrderDAOInterface orderDAOInterface=context.getBean(OrderDAOInterface.class);
      orderDAOInterface.insert(order);

      Promo promo =new Promo(1,product,new Date(),"vetements");
      PromoDAOInterface promoDAOInterface=context.getBean(PromoDAOInterface.class);
      promoDAOInterface.createPromo(promo);

      Review review=new Review(1,client,product,12,"bonn");
      ReviewDAOInterface reviewDAOInterface=context.getBean(ReviewDAOInterface.class);
      reviewDAOInterface.addReview(review);
      */
    public static void main(String[] args) {
        System.out.println("ok ok ok");
    }

}
