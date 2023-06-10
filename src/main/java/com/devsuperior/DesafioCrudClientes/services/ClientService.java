package com.devsuperior.DesafioCrudClientes.services;

import com.devsuperior.DesafioCrudClientes.dto.ClientDto;
import com.devsuperior.DesafioCrudClientes.entities.Client;
import com.devsuperior.DesafioCrudClientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDto findById(Long id) {
        Client client = clientRepository.findById(id).get();
        return new ClientDto(client);
    }
}
