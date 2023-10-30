package com.videoclubat.videoclubat.services;

import com.videoclubat.videoclubat.dto.ClientDTO;

import java.util.List;

public interface IClientServices {

    List<ClientDTO> getAllClients();
    ClientDTO getClientById(long id);
}
