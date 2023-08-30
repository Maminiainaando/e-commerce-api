package com.example.springbootexam.repository;
import com.example.springbootexam.model.Cart;
import com.example.springbootexam.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Repository
public class CartDAO implements CartDAOInterface{
    private Connection connection;
   public CartDAO(Connection connection){
        this.connection=connection;
    }
    @Override
    public Cart insert(Cart cart) {
        String resultat;
        String sql="INSERT INTO cart(cartid,typeCart,usercart) VALUES (?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
           statement.setInt(1,cart.getCartId());
           statement.setString(2, cart.getTypeCart());
           statement.setString(3,cart.getUsercart());
            statement.executeQuery();
            System.out.println("Insertion reussit");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return cart;
    }
    @Override
    public List<Cart> findAll() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from cart");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getString("usercart"));
                System.out.print(" has ");
                System.out.print(result.getString("typecart"));
                System.out.print(" Number cart : ");
                System.out.println(result.getInt("cartid"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Optional<Cart> updateCartUserCart(String newuser, String usercart){
       Statement statement;
       try{
          String sql=String.format("update cart set usercart='%s' where usercart='%s'",newuser,usercart);
          statement=connection.createStatement();
          statement.executeUpdate(sql);
       }catch (SQLException e){
           System.out.println(e.getMessage());
       }
        return null;
    }
    @Override
    public Optional<Cart> updateCartType(String newtype, String typecart) {
        Statement statement;
        try{
            String sql=String.format("update cart set typecart='%s' where typecart='%s'",newtype,typecart);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Optional<Cart> searchcartUsercart(String usercart) {
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from cart where usercart= '%s'",usercart);
            statement=connection.createStatement();
            rs= statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getInt("cartid")+" ");
                System.out.print(rs.getString("typecart")+" ");
                System.out.println(rs.getString("usercart"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Optional<Cart> searchcartType(String typecart) {
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from cart where typecart= '%s'",typecart);
            statement=connection.createStatement();
            rs= statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getInt("cartid")+" ");
                System.out.print(rs.getString("typecart")+" ");
                System.out.println(rs.getString("usercart"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Optional<Cart> deleteByUser(String usercart) {
        Statement statement;
        try{
            String query=String.format("delete from cart where usercart='%s'",usercart);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public Optional<Cart> searchcartById(int cartid) {
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from cart where cartid= '%s'",cartid);
            statement=connection.createStatement();
            rs= statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getInt("cartid")+" ");
                System.out.print(rs.getString("typecart")+" ");
                System.out.println(rs.getString("usercart"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Optional<Cart> deleteByType(String typecart) {
        Statement statement;
        try{
            String query=String.format("delete from cart where typecart='%s'",typecart);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    /*public  void main(String[] args) throws SQLException {
        //Client pate=new Client(6,"rrrr","03498888");
     //Cart vvvv=new Cart(98,"abc","natiora",pate);
        //Connection connection1;
       //new DatabaseConfiguration();
       //dao.insert(ando);
       //dao.findAll();
       //dao.updateCartType("aintsa","ndekzr");
       //dao.updateCartUserCart("cvbh","ando");
       //dao.findAll();
        //dao.findAll();
       /*dao.searchcartUsercart("cv");
       dao.searchcartType("aintsa");*/
       //dao.deleteByType("aintsa");
        //dao.insert(vvvv);
        /*dao.searchcartById(98);*/
        //CartDAOInterface dao=new CartDAO(DatabaseConfiguration);
        //dao.findAll();
    /*}*/
    public static void main(String[] args) {
        System.out.printf("ok");
    }
}



