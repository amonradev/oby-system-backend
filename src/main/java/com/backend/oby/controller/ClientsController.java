package com.backend.oby.controller;

import com.backend.oby.entity.Clients;
import com.backend.oby.exception.ResourceNotFoundException;
import com.backend.oby.repository.ClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
    private ClientsRepository clientsRepository;

    @GetMapping
    public List<Clients> getAllClients() {
        return this.clientsRepository.findAll();
    }

    @PostMapping
    public Clients createClient(@RequestBody Clients clients) {
        return this.clientsRepository.save(clients);
    }

    @GetMapping("/{id}")
    public Clients getClientById(@PathVariable (value = "id") long clientsId) {
        return this.clientsRepository.findById(clientsId)
        .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + clientsId));
    }

    @PutMapping("/{id}")
	public Clients updateClients(@RequestBody Clients client, @PathVariable ("id") long clientsId) {
		 Clients existingClient = this.clientsRepository.findById(clientsId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + clientsId));
		 existingClient.setName(existingClient.getName());
		 existingClient.setDescription(existingClient.getDescription());
		 existingClient.setSatisfaction(existingClient.getSatisfaction());
		 return this.clientsRepository.save(existingClient);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Clients> deleteUser(@PathVariable ("id") long clientsId){
		 Clients existingClients = this.clientsRepository.findById(clientsId)
					.orElseThrow(() -> new ResourceNotFoundException("Clients not found with id: " + clientsId));
		 this.clientsRepository.delete(existingClients);
		 return ResponseEntity.ok().build();
	}
}
