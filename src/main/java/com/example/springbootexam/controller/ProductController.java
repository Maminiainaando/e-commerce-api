package com.example.springbootexam.controller;

import com.example.springbootexam.model.Product;
import com.example.springbootexam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product insertProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/products")
    public List<Product> allProducts() {
        return productService.ProductList();
    }

    @GetMapping("/products/name/{productname}")
    public Optional<Product> productByName(@PathVariable String productname) {
        return Optional.ofNullable(productService.productByName(productname));
    }

    @GetMapping("/products/category/{category}")
    public Product productByCategory(@PathVariable String category) {
        return productService.productByCategory(category);
    }

    @PutMapping("/products/category/{category}")
    public Optional<Product> updateCategory(@PathVariable String category, @RequestBody String newCategory) {
        return Optional.ofNullable(productService.updateCategory(category, newCategory));
    }

    @DeleteMapping("/products/id/{productid}")
    public Optional<Product> deleteProductById(@PathVariable int productid) {
        return productService.deleteProductId(productid);
    }

    @DeleteMapping("/products/name/{productname}")
    public Optional<Product> deleteProductByName(@PathVariable String productname) {
        return productService.deleteProductname(productname);
    }
}
  /*  private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping("/product")
    public Product insertProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    @GetMapping("/product")
    public List<Product> allProduct(){
        return productService.ProductList();
    }
    @GetMapping("/product/{productname}")
    public Optional<Product> productByname(@PathVariable String productname){
        return Optional.ofNullable(productService.productByName(productname));
    }
    @GetMapping("/product/{category}")
    public Product productBycategory(@PathVariable String category){
        return productService.productByCategory(category);
    }
    @GetMapping("/product/{category}")
    public Optional<Product> updatecategory(@PathVariable String newcategory,String category) {
        return Optional.ofNullable(productService.updateCategory(newcategory, category));
    }
    @DeleteMapping("/product/{productid}")
    public Optional<Product> DeleteProductById(@PathVariable int productid){
        return productService.deleteProductId(productid);
    }
    @DeleteMapping("/product/{productname}")
    public Optional<Product> DeleteProductByName(@PathVariable String productname){
        return productService.deleteProductname(productname);
    }
}*/
