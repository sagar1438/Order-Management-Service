package com.sagar.ordermanagement
.services;

import com.sagar.ordermanagement
.dto.responses.ClientResponseDTO;
import com.sagar.ordermanagement
.dto.requests.ClientRequestDTO;
import java.util.List;

public interface ClientService {

    List<ClientResponseDTO> findAll();

    ClientResponseDTO findById(Long id);

    ClientResponseDTO insert(ClientRequestDTO dto);

     void delete(Long id);
}




