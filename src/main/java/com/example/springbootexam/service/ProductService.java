package com.example.springbootexam.service;

import com.example.springbootexam.model.Product;
import com.example.springbootexam.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductService {
    private final ProductDAO productDAO;
    @Autowired
    public ProductService(ProductDAO productDAO){
        this.productDAO=productDAO;
    }
    public Product createProduct(Product product){
        return productDAO.createProduct(product);

    }
    public List<Product> ProductList(){
        return productDAO.findAllProduct();
    }
    public Product productByName(String productName){
        return productDAO.searchProductname(productName);
    }
    public Product productByCategory(String category){
        return productDAO.searchcategory(category);
    }
    public void getStock(){
        productDAO.stockProduct();
    }
    public Product updateCategory(String newcategory, String category){
        return  productDAO.updateCategory(newcategory,category);
    }
    public Optional<Product> deleteProductId(int productid){
        System.out.println(productDAO.deleteByid(productid));
        return null;
    }
    public Optional<Product> deleteProductname(String productname){
        System.out.println(productDAO.deleteByname(productname));
        return null;
    }
}
