package com.example.springbootexam.repository;

import com.example.springbootexam.model.Client;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
@Repository
public class ClientDAO implements ClientDAOInterface{
    private Connection connection;

    public ClientDAO(Connection connection){
        this.connection = connection;
    }


    @Override
    public Client insert (Client client){
        String resultat;
        String sql="INSERT INTO client(clientid,clientname,phonenumber) VALUES (?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,client.getClientId());
            statement.setString(2, client.getClientName());
            statement.setString(3,client.getPhoneNumber());
            statement.executeQuery();
            System.out.println("Insertion reussit");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return client;
    }
    @Override
    public List<Client> findAll() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from client");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getString("clientname"));
                System.out.print(" has ");
                System.out.print(result.getString("phonenumber"));
                System.out.print(" Number client : ");
                System.out.println(result.getInt("clientid"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Client updateClientName(String newclientName, String clientName) {
        Statement statement;
        try{
            String sql=String.format("update client set clientname='%s' where clientname='%s'",newclientName,clientName);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Client updatephoneNumber(String newnumber, String phoneNumber) {
        Statement statement;
        try{
            String sql=String.format("update client set phonenumber='%s' where phonenumber='%s'",newnumber,phoneNumber);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Client searchClientName(String clientName){
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from client where clientname= '%s'",clientName);
            statement=connection.createStatement();
            rs= statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getInt("clientid")+" ");
                System.out.print(rs.getString("clientname")+" ");
                System.out.println(rs.getString("phonenumber"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Client searchphoneNumber(String phoneNumber) {
        Statement statement;
        ResultSet rs=null;
        try{
            String query=String.format("select * from client where phonenumber= '%s'",phoneNumber);
            statement=connection.createStatement();
            rs= statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getInt("clientid")+" ");
                System.out.print(rs.getString("clientname")+" ");
                System.out.println(rs.getString("phonenumber"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteClientName(int clientid) {
        Statement statement;
        try{
            String query=String.format("delete from client where clientid='%s'",clientid);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public List<Client> searchClients(String keyword) {
        return null;
    }

    public static void main(String[] args) {
        /*Client client2=new Client(2,"okoooj","8888");
        //Cart natiora=new Cart(1,"abc","natiora",client);
        //Connection connection1;
        //CartDAOInterface dao=new CartDAO(DatabaseConfiguration.getConnection());
        //dao.insert(ando);
        //ClientDAOInterface dao=new ClientDAO((Connection) new DatabaseConfiguration());
        //dao.insert(client);
        //dao.insert(client2);
        //dao.findAll();
        //dao.updateCartType("aintsa","ndekzr");
        //dao.updateCartUserCart("cvbh","ando");
        //dao.findAll();
        //dao.deleteClientName(1);
        //dao.findAll();*/
    }
}
