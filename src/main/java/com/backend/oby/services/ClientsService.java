package com.backend.oby.services;

import java.util.List;

import com.backend.oby.entity.Clients;
import com.backend.oby.exception.ResourceNotFoundException;
import com.backend.oby.repository.ClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
    
    @Autowired
    private ClientsRepository clientsRepository;

    public List<Clients> getAllClients() {
        return this.clientsRepository.findAll();
    }

    public Clients createClient(Clients clients) {
        return this.clientsRepository.save(clients);
    }

    public Clients getClientById(long clientsId) {
        return this.clientsRepository.findById(clientsId)
        .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + clientsId));
    }

	public Clients updateClients(Clients client) {
        return this.clientsRepository.save(client);
	}
	
	public void deleteUser(long clientsId){
		 Clients existingClients = this.clientsRepository.findById(clientsId)
					.orElseThrow(() -> new ResourceNotFoundException("Clients not found with id: " + clientsId));
		 this.clientsRepository.delete(existingClients);
	}
}
