package com.example.springbootexam.controller;

import com.example.springbootexam.model.*;
import com.example.springbootexam.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EcmmerceController {
    private ECommerceService eCommerceService;

    @Autowired
    public EcmmerceController(ECommerceService eCommerceService) {
        this.eCommerceService = eCommerceService;
    }

    @PostMapping("/ECommerce/client")
    public ECommerce allClient(@RequestBody Client client) {
        return (ECommerce) eCommerceService.listClient(client);
    }

    @PostMapping("/ECommerce/user")
    public ECommerce allUser(@RequestBody User user) {
        return (ECommerce) eCommerceService.UserList(user);
    }

    @PostMapping("/ECommerce/product")
    public ECommerce allProduct(@RequestBody Product product) {
        return (ECommerce) eCommerceService.productList(product);
    }

    @GetMapping("/ECommerce/{category}")
    public ECommerce allCategory(@PathVariable String category) {
        return eCommerceService.getAllCategory(category);
    }
}
/*
@RestController
public class EcmmerceController {
 private ECommerceService eCommerceService;
 public EcmmerceController(ECommerceService eCommerceService){
     this.eCommerceService=eCommerceService;
 }
 @PostMapping("/ECommerce")
 public ECommerce AllClient(@RequestBody Client client){
     return (ECommerce) eCommerceService.listClient(client);
 }
    @PostMapping("/ECommerce")
    public ECommerce AllUser(@RequestBody User user){
        return (ECommerce) eCommerceService.UserList(user);
    }
    @PostMapping("/ECommerce")
    public ECommerce AllProduct(@RequestBody Product product){
        return (ECommerce) eCommerceService.productList(product);
    }
    @GetMapping("/ECommerce/{category}")
    public ECommerce AllCategory(@PathVariable String category){
        return eCommerceService.getAllCategory(category);
    }*/
//}
