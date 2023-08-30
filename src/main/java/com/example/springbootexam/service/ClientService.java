package com.example.springbootexam.service;

import com.example.springbootexam.model.Client;
import com.example.springbootexam.repository.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientDAO clientDAO;
    @Autowired
    public ClientService (ClientDAO clientDAO){
        this.clientDAO=clientDAO;
    }
    public Client addClient(Client client) {
        return clientDAO.insert(client);
    }

    public List<Client> clientList() {
        return clientDAO.findAll();
    }
    public Client getClientByName(String clientname) {
        return clientDAO.searchClientName(clientname);
    }
    public Client getCartByPhonenumber(String phone) {
        return clientDAO.searchphoneNumber(phone);
    }
    public Client changeClient(String newclient, String oldclient) {
        return clientDAO.updateClientName(newclient, oldclient);
    }
    public Client changePhone(String newphone, String oldphone) {
        return clientDAO.updatephoneNumber(newphone, oldphone);
    }

    public Optional<Client> deleteClient(int clientid) {
        System.out.println(clientDAO.deleteClientName(clientid));
        return null;
    }
}
