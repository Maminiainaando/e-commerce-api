package com.example.springbootexam.repository;

import com.example.springbootexam.model.Review;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
@Repository
public class ReviewDAO implements ReviewDAOInterface{
    private Connection connection;

    public ReviewDAO(Connection connection){
        this.connection = connection;
    }
    @Override
    public Review addReview(Review review) {
        String resultat;
        String sql="INSERT INTO review(reviewid,rating,comment) VALUES (?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,review.getReviewId());
            statement.setInt(2, review.getRating());
            statement.setString(3,review.getComment());
            statement.executeQuery();
            System.out.println("Insertion reussit");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return review;
    }
    @Override
    public List<Review> findAllReview() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from review");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getInt("reviewid"));
                System.out.print(result.getInt("rating"));
                System.out.print(result.getString("comment"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Review updatecomment(String newcomment, String comment) {
        Statement statement;
        try{
            String sql=String.format("update review set comment='%s' where comment='%s'",newcomment,comment);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Review updaterating(int newrate, int rate) {
        Statement statement;
        try{
            String sql=String.format("update review set comment='%s' where comment='%s'",newrate,rate);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public boolean deleteReview(int reviewid) {
        Statement statement;
        try{
            String query=String.format("delete from review where reviewid='%s'",reviewid);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    @Override
    public Review findAllComment() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select comment from review");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getInt("reviewid"));
                System.out.print(result.getInt("rating"));
                System.out.print(result.getString("comment"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
