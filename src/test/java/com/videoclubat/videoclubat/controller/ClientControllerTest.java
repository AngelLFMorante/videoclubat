package com.videoclubat.videoclubat.controller;

import com.videoclubat.videoclubat.dto.ClientDTO;
import com.videoclubat.videoclubat.entity.Client;
import com.videoclubat.videoclubat.services.impl.ClientServicesImpl;
import com.videoclubat.videoclubat.utils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class ClientControllerTest {

    @Mock
    private ClientServicesImpl services;

    @InjectMocks
    private ClientController controller;

    @BeforeEach
    void setUp() {
        openMocks(this);
        controller = new ClientController(services);
    }

    @Test
    void getAllClients() {
        when(services.getAllClients()).thenReturn(Data.getClientsListDTO());

        ResponseEntity<Object> resultList = controller.getAllClients();

        assertNotNull(resultList.getBody());
        assertEquals(HttpStatus.OK, resultList.getStatusCode());
        verify(services).getAllClients();
    }

    @Test
    void getClientById() {
        when(services.getClientById(anyLong())).thenReturn(Data.getClientDTO());

        ResponseEntity<Object> resultClient = controller.getClientById(anyLong());

        assertNotNull(resultClient.getBody());
        assertEquals(ClientDTO.class, resultClient.getBody().getClass());
        assertEquals(HttpStatus.OK, resultClient.getStatusCode());
        verify(services).getClientById(anyLong());
    }

    @Test
    void addNewClient() {
        when(services.addClient(Data.getClient())).thenReturn(Data.getClientDTO());

        ResponseEntity<Object> resultAddClient = controller.addNewClient(Data.getClient());

        assertNotNull(resultAddClient.getBody());
        assertEquals(ClientDTO.class, resultAddClient.getBody().getClass());
        assertEquals(HttpStatus.CREATED, resultAddClient.getStatusCode());
        verify(services).addClient(Data.getClient());
    }

    @Test
    void editClient() {
        when(services.editClient(1L, Data.getClient())).thenReturn(Data.getClientDTO());

        ResponseEntity<Object> resultEditClient = controller.editClient(1L, Data.getClient());

        assertNotNull(resultEditClient.getBody());
        assertEquals(ClientDTO.class, resultEditClient.getBody().getClass());
        assertEquals(HttpStatus.OK, resultEditClient.getStatusCode());
        verify(services).editClient(1L, Data.getClient());
    }

    @Test
    void deleteClient() {

        ResponseEntity<Object> resultEditClient = controller.deleteClient(anyLong());

        assertEquals(HttpStatus.NO_CONTENT, resultEditClient.getStatusCode());
        verify(services).deleteClientById(anyLong());
    }
}