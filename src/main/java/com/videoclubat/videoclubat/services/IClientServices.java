package com.videoclubat.videoclubat.services;

import com.videoclubat.videoclubat.dto.ClientDTO;
import com.videoclubat.videoclubat.entity.Client;

import java.util.List;

public interface IClientServices {

    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    ClientDTO addClient(Client client);
    ClientDTO editClient(Long id, Client client);
    void deleteClientById(Long id);
}
