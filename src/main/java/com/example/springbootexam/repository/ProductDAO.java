package com.example.springbootexam.repository;

import com.example.springbootexam.model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class ProductDAO implements ProductDAOInterface{
    private Connection connection;

    public ProductDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public Product createProduct(Product product) {
        String resultat;
        String sql="INSERT INTO product(productid,productname,price,stockquantity,category,categorydescription) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,product.getProductId());
            statement.setString(2,product.getProductName());
            statement.setFloat(3,product.getPrice());
            statement.setInt(4,product.getStockQuantity());
            statement.setString(5,product.getCategory());
            statement.setString(6,product.getCategoryDescription());
            statement.executeQuery();
            System.out.println("Insertion reussit");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public void stockProduct() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from product where stockquantity=0");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.println(result.getInt("productid"));
                System.out.println(result.getString("productname"));
                System.out.println(result.getFloat("price"));
                System.out.println(result.getInt("stockquantity"));
                System.out.println(result.getString("category"));
                System.out.println(result.getString("categorydesc"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Product> findAllProduct() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from product");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.println(result.getInt("productid"));
                System.out.println(result.getString("productname"));
                System.out.println(result.getFloat("price"));
                System.out.println(result.getInt("stockquantity"));
                System.out.println(result.getString("category"));
                System.out.println(result.getString("categorydesc"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Product updateCategory(String newcategory, String category) {
        Statement statement;
        try{
            String sql=String.format("update product set category='%s' where category='%s'",newcategory,category);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Product searchcategory(String category) {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from product where category= '%s'",category);
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.println(result.getInt("productid"));
                System.out.println(result.getString("productname"));
                System.out.println(result.getDouble("price"));
                System.out.println(result.getInt("stockquantity"));
                System.out.println(result.getString("category"));
                System.out.println(result.getString("categorydesc"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Product searchProductname(String productName) {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from product where productName= '%s'",productName);
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.println(result.getInt("productid"));
                System.out.println(result.getString("productname"));
                System.out.println(result.getDouble("price"));
                System.out.println(result.getInt("stockquantity"));
                System.out.println(result.getString("category"));
                System.out.println(result.getString("categorydesc"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteByid(int productId) {
        Statement statement;
        try{
            String query=String.format("delete from product where productid='%s'",productId);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean deleteByname(String productName) {
        Statement statement;
        try{
            String query=String.format("delete from product where productname='%s'",productName);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("okok");
    }

}
