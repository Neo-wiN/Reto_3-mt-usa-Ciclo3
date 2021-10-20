package com.boat.repository;

import com.boat.model.Client;
import com.boat.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Es el package que contiene las interfaces que extienden de JPA para que estas clases se conecten a la base de datos
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
}

