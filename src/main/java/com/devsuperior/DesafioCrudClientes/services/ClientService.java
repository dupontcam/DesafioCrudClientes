package com.devsuperior.DesafioCrudClientes.services;

import com.devsuperior.DesafioCrudClientes.dto.ClientDto;
import com.devsuperior.DesafioCrudClientes.entities.Client;
import com.devsuperior.DesafioCrudClientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDto findById(Long id) {
        Client client = clientRepository.findById(id).get();
        return new ClientDto(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(Pageable pageable){
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x -> new ClientDto(x));
    }

    @Transactional
    public ClientDto insert(ClientDto dto){
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDto(entity);
    }

    @Transactional
    public ClientDto update(Long id, ClientDto dto){
        Client entity = clientRepository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDto(entity);
    }

    @Transactional
    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    private void copyDtoToEntity(ClientDto dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());

        entity = clientRepository.save(entity);
    }
}
