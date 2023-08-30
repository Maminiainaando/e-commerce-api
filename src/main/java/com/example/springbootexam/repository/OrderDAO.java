package com.example.springbootexam.repository;

import com.example.springbootexam.model.Order;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
@Repository
public class OrderDAO implements OrderDAOInterface {
    private Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Order insert(Order order) {
            String resultat;
            String sql="INSERT INTO order(orderid,orderdate,offlineorder,quantity,unitPrice) VALUES (?,?,?,?,?)";
            try (PreparedStatement statement=connection.prepareStatement(sql)){
                statement.setInt(1,order.getOrderId());
                 statement.setDate(2, (Date) order.getOrderDate());
                 statement.setBoolean(3,order.getOfflineorder());
                 statement.setInt(4,order.getQuantity());
                 statement.setFloat(5,order.getUnitPrice());
                statement.executeQuery();
                System.out.println("Insertion reussit");
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return order;
    }

    @Override
    public List<Order> findAllOrder() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from orders");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getFloat("unitprice"));
                System.out.print(result.getBoolean("offline"));
                System.out.print(" Number order : ");
                System.out.println(result.getInt("orderid"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Order updatequantity(int newquantity, int quantity) {
        Statement statement;
        try{
            String sql=String.format("update orders set quantity='%s' where quantity='%s'",newquantity,quantity);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteOrder(int orderid) {
        Statement statement;
        try{
            String query=String.format("delete from orders where orderid='%s'",orderid);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
