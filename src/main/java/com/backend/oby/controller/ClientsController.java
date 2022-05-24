package com.backend.oby.controller;

import com.backend.oby.entity.Clients;
import com.backend.oby.exception.ResourceNotFoundException;
import com.backend.oby.services.ClientsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {
    
    @Autowired
    private ClientsService clientsService;

    @GetMapping
    public ResponseEntity<List<Clients>> getAllClients() {
        return new ResponseEntity<>(this.clientsService.getAllClients(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createClient(@RequestBody Clients clients) {
        this.clientsService.createClient(clients);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> getClientById(@PathVariable (value = "id") long clientsId) {
        this.clientsService.getClientById(clientsId);
        return new ResponseEntity<>(this.clientsService.getClientById(clientsId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
	public ResponseEntity<Void> updateClients(@RequestBody Clients client) {
        this.clientsService.updateClients(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable ("id") long clientsId){
        this.clientsService.deleteUser(clientsId);
        return new ResponseEntity<>(HttpStatus.OK);
	}
}
