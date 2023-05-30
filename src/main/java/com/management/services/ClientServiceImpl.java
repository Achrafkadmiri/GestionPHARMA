package com.management.services;
import com.management.entities.Client;
import com.management.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client saveClient(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {

        return clientRepository.findById(id).get();
    }
    @Override
    public Client getClient(Long id) {

        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }

    @Override
    public void deleteClientById(Long id) {

        clientRepository.deleteById(id);
    }

    @Override
    public void deleteAllClients() {
        clientRepository.deleteAll();
    }
}
