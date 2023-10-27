package com.videoclubat.videoclubat.services.impl;

import com.videoclubat.videoclubat.dto.ClientDTO;
import com.videoclubat.videoclubat.entity.Client;
import com.videoclubat.videoclubat.mapper.IClientMapper;
import com.videoclubat.videoclubat.repository.IClientRepository;
import com.videoclubat.videoclubat.services.IClientServicesDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServicesImpl implements IClientServicesDAO {

    final static Logger logger = LoggerFactory.getLogger(ClientServicesImpl.class);

    private final IClientRepository repository;
    private final IClientMapper mapper;

    @Override
    public List<Client> getAllClients() {
        logger.debug("Llamada para traer todos los clientes");
        return repository.findAll();
    }

    @Override
    public ClientDTO getClientById(int id) {
        Optional<Client> client = repository.findById(id);
        if(client.isEmpty()){
             logger.error("No existe cliente");
        }
        return mapper.mapperClientToDto(client.get());
    }

}
