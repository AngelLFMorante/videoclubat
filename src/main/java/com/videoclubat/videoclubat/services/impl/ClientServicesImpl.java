package com.videoclubat.videoclubat.services.impl;

import com.videoclubat.videoclubat.entity.Client;
import com.videoclubat.videoclubat.repository.IClientRepository;
import com.videoclubat.videoclubat.services.IClientServices;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServicesImpl implements IClientServices {

    private IClientRepository repository;

    public ClientServicesImpl(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Client> getAllClients() {
        return repository.findByAll();
    }
}
