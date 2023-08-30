/*package com.example.springbootexam.controller;

import com.example.springbootexam.model.Client;
import com.example.springbootexam.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;*/

/*@RestController
public class ClientController {
    private ClientService clientService;
    @GetMapping("/client/{usercart}")
    public Optional<Client> CartByPhonenumber(@PathVariable String phonenumber) {
        return Optional.ofNullable(clientService.getCartByPhonenumber(phonenumber));
    }

    @PutMapping("/client/{name}")

    public Client UpdateNameUser(@PathVariable String newname, String name) {
        return clientService.changePhone(newname, name);
    }

    @PutMapping("/cart/{phonenumber}")
    public Client UpdatePhonenumber(@PathVariable String newnumber, String number) {
        return clientService.changeClient(newnumber, newnumber);
    }
    @DeleteMapping("/client/{id}")
    public  Optional<Client> DeleteClient(@PathVariable int clientid){
        return clientService.deleteClient(clientid);
    }


}*/
package com.example.springbootexam.controller;

import com.example.springbootexam.model.Client;
import com.example.springbootexam.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{phonenumber}")
    public Optional<Client> CartByPhonenumber(@PathVariable String phonenumber) {
        return Optional.ofNullable(clientService.getCartByPhonenumber(phonenumber));
    }

    @PutMapping("/name/{name}")
    public Client UpdateNameUser(@PathVariable String newname, @RequestParam String name) {
        return clientService.changePhone(newname, name);
    }

    @PutMapping("/phonenumber/{phonenumber}")
    public Client UpdatePhonenumber(@PathVariable String newnumber, @RequestParam String number) {
        return clientService.changeClient(newnumber, number);
    }

    @DeleteMapping("/{id}")
    public Optional<Client> DeleteClient(@PathVariable int id) {
        return clientService.deleteClient(id);
    }
}

