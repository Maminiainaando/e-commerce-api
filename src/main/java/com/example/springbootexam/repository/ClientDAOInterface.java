package com.example.springbootexam.repository;

import com.example.springbootexam.model.Client;


import java.sql.SQLException;
import java.util.List;

public interface ClientDAOInterface {
    Client insert(Client client);
    List<Client> findAll();
    Client updateClientName(String newclientName, String clientName);
    Client updatephoneNumber(String newnumber, String phoneNumber);
    Client searchClientName(String clientName);
    Client searchphoneNumber(String phoneNumber);
    boolean deleteClientName(int clientid);
    List<Client> searchClients(String keyword);
}
