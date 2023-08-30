/*package com.example.springbootexam.controller;

import com.example.springbootexam.model.Cart;
import com.example.springbootexam.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {
    /**/
    /*private CartService cartService;
    public CartController (CartService cartService){
        this.cartService=cartService;
    }
    @PostMapping("/cart")
    public Cart insertCart(@RequestBody Cart cart){
        return cartService.create(cart);
    }
    @GetMapping("/cart")
    public List<Cart> getAllCart(){
        return cartService.CartList();
    }
    @GetMapping("/cart/{cartid}")
    public Optional<Cart> CartById(@PathVariable int id){
        return cartService.searchId(id);
    }
    @GetMapping("/cart/{usercart}")
    public Optional<Cart> CartByUser(@PathVariable String usercart){
        return cartService.searchUserCart(usercart);
    }
    @GetMapping("/cart/{typecart}")
    public Optional<Cart> CartByType(@PathVariable String typecart){
        return cartService.searchCartType(typecart);
    }
    @DeleteMapping("/cart/{typecart}")
    public Optional<Cart> DeleteCartByType(@PathVariable String typecart){
        return cartService.deleteCartType(typecart);
    }
    @DeleteMapping("/cart/{usercart}")
    public Optional<Cart> DeleteCartByUser(@PathVariable String usercart){
       return cartService.deleteUserCart(usercart);
    }
    @PutMapping("/cart/{typecart}")
    public Optional<Cart> UpdateTypecart(@PathVariable String newtypecart, String typecart){
        return cartService.updateCartType(newtypecart,typecart);
    }
    @PutMapping("/cart/{usercart}")
    public Optional<Cart> UpdateUsercart(@PathVariable String newusercart, String usercart){
        return cartService.updateUserCart(newusercart,usercart);
    }
}*/
package com.example.springbootexam.controller;

import com.example.springbootexam.model.Cart;
import com.example.springbootexam.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")  // Group common path
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping
    public Cart insertCart(@RequestBody Cart cart){
        return cartService.create(cart);
    }

    @GetMapping
    public List<Cart> getAllCart(){
        return cartService.CartList();
    }

    @GetMapping("/{cartid}")
    public Optional<Cart> CartById(@PathVariable int cartid){
        return cartService.searchId(cartid);
    }

    @GetMapping("/user/{usercart}")
    public Optional<Cart> CartByUser(@PathVariable String usercart){
        return cartService.searchUserCart(usercart);
    }

    @GetMapping("/type/{typecart}")
    public Optional<Cart> CartByType(@PathVariable String typecart){
        return cartService.searchCartType(typecart);
    }

    @DeleteMapping("/type/{typecart}")
    public void DeleteCartByType(@PathVariable String typecart){
        cartService.deleteCartType(typecart);
    }

    @DeleteMapping("/user/{usercart}")
    public void DeleteCartByUser(@PathVariable String usercart){
        cartService.deleteUserCart(usercart);
    }

    @PutMapping("/type/{typecart}")
    public Optional<Cart> UpdateTypecart(@PathVariable String newtypecart, @RequestParam String typecart){
        return cartService.updateCartType(newtypecart, typecart);
    }

    @PutMapping("/user/{usercart}")
    public Optional<Cart> UpdateUsercart(@PathVariable String newusercart, @RequestParam String usercart){
        return cartService.updateUserCart(newusercart, usercart);
    }
}
