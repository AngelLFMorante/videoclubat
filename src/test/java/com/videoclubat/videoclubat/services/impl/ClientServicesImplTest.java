package com.videoclubat.videoclubat.services.impl;

import com.videoclubat.videoclubat.dto.ClientDTO;
import com.videoclubat.videoclubat.mapper.IClientMapper;
import com.videoclubat.videoclubat.repository.IClientRepository;
import com.videoclubat.videoclubat.utils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
class ClientServicesImplTest {

    @Mock
    private IClientRepository repository;

    @Mock
    private IClientMapper mapper;

    @InjectMocks
    private ClientServicesImpl clientServices;

    @BeforeEach
    void setUp() {
        openMocks(this);
        clientServices = new ClientServicesImpl(repository, mapper);
    }


    @Test
    void getAllClients() {
        when(repository.findAll()).thenReturn(Data.getClientsList());
        when(mapper.mapperClientToDto(Data.getClient())).thenReturn(Data.getClientDTO());

        List<ClientDTO> result = clientServices.getAllClients();

        assertNotNull(result);
        assertEquals("Jose", result.get(0).getName());
        assertEquals(1, result.size());
        verify(repository).findAll();
    }

    @Test
    void testGetClientById() {
        when(repository.findById(anyLong())).thenReturn(Data.getOptionalClient());
        when(mapper.mapperClientToDto(Data.getClient())).thenReturn(Data.getClientDTO());

        ClientDTO result = clientServices.getClientById(1L);

        assertNotNull(result);
        assertEquals("Jose", result.getName());
        verify(repository).findById(anyLong());
    }

    @Test
    void addClient() {
        when(repository.save(Data.getClient())).thenReturn(Data.getClient());
        when(mapper.mapperClientToDto(Data.getClient())).thenReturn(Data.getClientDTO());

        ClientDTO result = clientServices.addClient(Data.getClient());

        assertNotNull(result);
        assertEquals("Jose", result.getName());
        verify(repository).save(Data.getClient());
    }

    @Test
    void editNewClient() {
        when(repository.save(Data.getClient())).thenReturn(Data.getClient());
        when(mapper.mapperClientToDto(Data.getClient())).thenReturn(Data.getClientDTO());

        ClientDTO result = clientServices.editClient(1L, Data.getClient());

        assertNotNull(result);
        assertEquals("Jose", result.getName());
        verify(repository).save(Data.getClient());
    }

    @Test
    void editClient() {
        when(repository.findById(2L)).thenReturn(Data.getOptionalClient());
        when(repository.save(Data.getClient())).thenReturn(Data.getClient());
        when(mapper.mapperClientToDto(Data.getClient())).thenReturn(Data.getClientDTO());

        ClientDTO result = clientServices.editClient(2L, Data.getClient());

        assertNotNull(result);
        assertEquals("Jose", result.getName());
        verify(repository).save(Data.getClient());
    }

    @Test
    void deleteClientById() {
        when(repository.findById(2L)).thenReturn(Data.getOptionalClient());

        clientServices.deleteClientById(2L);

        verify(repository).findById(anyLong());
        verify(repository).deleteById(anyLong());
    }
}