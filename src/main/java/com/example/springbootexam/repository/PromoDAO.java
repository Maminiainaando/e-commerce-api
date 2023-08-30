package com.example.springbootexam.repository;

import com.example.springbootexam.model.Promo;
import com.example.springbootexam.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;
import java.util.List;
@Repository
public class PromoDAO implements PromoDAOInterface{
    private Connection connection;

    public PromoDAO(Connection connection){
        this.connection = connection;
    }


    @Override
    public Promo createPromo(Promo promo) {
        String resultat;
        String sql="INSERT INTO promo(promoid,expirationdate,category) VALUES (?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,promo.getPromoid());
            statement.setString(3,promo.getCategory());
            statement.setDate(2, (java.sql.Date) promo.getExpirationDate());
            statement.executeQuery();
            System.out.println("Insertion reussit");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return promo;
    }

    @Override
    public Promo searchPromo(int promoid) {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from promo where promoid= '%s'",promoid);
            statement=connection.createStatement();
            result= statement.executeQuery(query);
            while(result.next()){
                System.out.println(result.getInt("promoid"));
                System.out.println(result.getDate("expirationdate"));
                System.out.println(result.getString("category"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Promo updatePromo(Date newExpiration, Date expiration) {
        Statement statement;
        try{
            String sql=String.format("update promo set expirationdate='%s' where expirationdate='%s'",newExpiration,expiration);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deletePromo(int promoid) {
        Statement statement;
        try{
            String query=String.format("delete from promo where usercart='%s'",promoid);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public List<Promo> allPromo() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from promo");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.println(result.getInt("promoid"));
                System.out.println(result.getDate("expirationdate"));
                System.out.println(result.getString("category"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return (List<Promo>) result;
    }

    @Override
    public Promo searchcategorypromo(String category) {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from promo where category= '%s'",category);
            statement=connection.createStatement();
            result= statement.executeQuery(query);
            while(result.next()){
                System.out.println(result.getInt("promoid"));
                System.out.println(result.getDate("expirationdate"));
                System.out.println(result.getString("category"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
