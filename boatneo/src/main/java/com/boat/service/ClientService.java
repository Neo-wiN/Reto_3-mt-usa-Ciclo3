package com.boat.service;

import com.boat.model.Client;
import com.boat.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // se encarga de gestionar las operaciones de negocio más importantes a nivel de la aplicación y aglutina llamadas a varios repositorios de forma simultánea 
public class ClientService {

    @Autowired  //se trata de la anotación que permite inyectar unas dependencias con otras dentro de Spring 
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId) {
        return clientRepository.getClient(clientId);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if (e.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
}
