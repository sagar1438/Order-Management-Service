package com.sagar.ordermanagement
.services.impl;

import com.sagar.ordermanagement
.dto.responses.ClientResponseDTO;
import com.sagar.ordermanagement
.dto.requests.ClientRequestDTO;
import com.sagar.ordermanagement
.entities.Client;
import com.sagar.ordermanagement
.exceptions.ClientNotFoundException;
import com.sagar.ordermanagement
.repositories.ClientRepository;
import com.sagar.ordermanagement
.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    public ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClientResponseDTO> findAll() {
        List<Client> list = repository.findAll();
        return list.stream().map(ClientResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public ClientResponseDTO findById(Long id) throws ClientNotFoundException {
        return new ClientResponseDTO(repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id)));
    }

    @Override
    public ClientResponseDTO insert(ClientRequestDTO dto) {
        Client clientToSave = repository.save(new Client(dto));
        return new ClientResponseDTO(clientToSave);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
