package com.sagar.ordermanagement.services;

import com.sagar.ordermanagement.dto.requests.ClientRequestDTO;
import com.sagar.ordermanagement.dto.responses.ClientResponseDTO;
import com.sagar.ordermanagement.entities.Client;
import com.sagar.ordermanagement.exceptions.ClientNotFoundException;
import com.sagar.ordermanagement.repositories.ClientRepository;
import com.sagar.ordermanagement.services.impl.ClientServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTests {

    private ClientServiceImpl service;
    private final ClientRepository repository = Mockito.mock(ClientRepository.class);
    private Client templateClient;

    @BeforeEach
    void setUp() {
    service = new ClientServiceImpl(repository);

    templateClient = new Client();
    templateClient.setId(1L);
    templateClient.setName("Sagar");
    templateClient.setEmail("sagarpanwar202@gmail.com");
}

    private void assertClientsAreEqual(ClientResponseDTO actual, ClientResponseDTO expected) {
        assertAll(() -> actual.getEmail().equals(expected.getEmail()),
                () -> actual.getName().equals(expected.getName()),
                () -> actual.getId().equals(expected.getId()));
    }

    @Test
    @DisplayName("Should return valid client dto when id is valid")
    void shouldReturnValidClientWhenIdIsValid() {
        var actual = service.findById(1L);
        Client expectedClient = new Client();
        expectedClient.setId(1L);
        expectedClient.setName("Sagar");
        expectedClient.setEmail("sagarpanwar202@gmail.com");
        var expected = new ClientResponseDTO(expectedClient);

    }

    @Test
    @DisplayName("Should throw ClientNotFoundException when given invalid id")
    void shouldThrowClientNotFoundExceptionWhenGivenInvalidId() {
        assertThrows(ClientNotFoundException.class, () -> service.findById(10L));
    }

    @Test
    @DisplayName("Should return list of clients")
    void shouldReturnListOfClients() {
        var actual = service.findAll();
        Assertions.assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(actual.get(0).getName(), templateClient.getName()),
                () -> assertEquals(actual.get(0).getEmail(), templateClient.getEmail()),
                () -> assertEquals(actual.get(0).getId(), templateClient.getId()));
    }

    @Test
    @DisplayName("Should return empty list when database is empty")
    void ShouldReturnEmptyListWhenDatabaseIsEmpty() {
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<Client>());
        var expected = service.findAll();
        assertTrue(expected.isEmpty());
    }

    // TODO: Implement return, mock repository to return registry with id
    @Test
    @Disabled
    @DisplayName("Should insert new client and return ClientResponse when valid args")
    void ShouldInsertNewClientAndReturnClientResponseWhenValidArgs() {
        assertTrue(true);
    }
}
