package com.videoclubat.videoclubat.services.impl;

import com.videoclubat.videoclubat.entity.Client;
import com.videoclubat.videoclubat.repository.IClientRepository;
import com.videoclubat.videoclubat.services.IClientServices;
import com.videoclubat.videoclubat.utils.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
class ClientServicesImplTest {

    @Mock
    private IClientRepository repository;

    @InjectMocks
    private IClientServices clientServices = new ClientServicesImpl(repository);

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void getAllClients() {
        when(repository.findByAll()).thenReturn(Data.getAllClients());

        Optional<Client> result = clientServices.getAllClients();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Angel", result.get().getFirstname());
        verify(repository).findByAll();
    }
}