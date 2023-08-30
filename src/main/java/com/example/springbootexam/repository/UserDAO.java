package com.example.springbootexam.repository;

import com.example.springbootexam.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;
@Repository
public class UserDAO implements UserDAOInterface{
    private Connection connection;
    public UserDAO(Connection connection){
        this.connection=connection;
    }
    @Override
    public User insert(User user) {
        String resultat;
        String sql="INSERT INTO users(id,username,email,work,password) VALUES (?,?,?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,user.getId());
            statement.setString(2,user.getUsername());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getWork());
            statement.setString(5,user.getPassword());
            statement.executeQuery();
            System.out.println("Insertion reussit");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean findAllUser() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from users");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getInt("id"));
                System.out.print(result.getString("username"));
                System.out.print(result.getString("email"));
                System.out.print(result.getString("work"));
                System.out.print(result.getString("password"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public User updatework(String newwork, String work) {
        Statement statement;
        try{
            String sql=String.format("update users set work='%s' where work='%s'",newwork,work);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public User searchByWork(String work) {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from users where typecart= '%s'",work);
            statement=connection.createStatement();
            result= statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getInt("id"));
                System.out.print(result.getString("username"));
                System.out.print(result.getString("email"));
                System.out.print(result.getString("work"));
                System.out.print(result.getString("password"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteByUsername(String username) {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from users where usercart= '%s'",username);
            statement=connection.createStatement();
            result= statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getInt("id"));
                System.out.print(result.getString("username"));
                System.out.print(result.getString("email"));
                System.out.print(result.getString("work"));
                System.out.print(result.getString("password"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Statement statement;
        try{
            String query=String.format("delete from users where id='%s'",id);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
        User user=new User(1,"aina","aina@gmail.com","prof","1234");
        UserDAOInterface userDAOInterface=context.getBean(UserDAOInterface.class);
        userDAOInterface.insert(user);
        context.close();
    }
}
