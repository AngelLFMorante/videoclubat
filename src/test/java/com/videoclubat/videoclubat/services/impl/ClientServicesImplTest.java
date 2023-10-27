package com.videoclubat.videoclubat.services.impl;

import com.videoclubat.videoclubat.mapper.IClientMapper;
import com.videoclubat.videoclubat.repository.IClientRepository;
import com.videoclubat.videoclubat.services.IClientServicesDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
class ClientServicesImplTest {

    @Mock
    private IClientRepository repository;

    @Mock
    private IClientMapper mapper;

    @InjectMocks
    private IClientServicesDAO clientServices = new ClientServicesImpl(repository, mapper);

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void getClientById() {
       /* when(repository.findById(1)).thenReturn(Data.getClientById());

        Optional<Client> result = clientServices.getClientById(1);

        Assertions.assertNotNull(result);
        //Assertions.assertEquals("Angel", result.get().getFirstname());
        verify(repository).findById(1);*/
    }
}