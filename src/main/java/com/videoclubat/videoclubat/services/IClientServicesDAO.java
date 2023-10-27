package com.videoclubat.videoclubat.services;

import com.videoclubat.videoclubat.dto.ClientDTO;
import com.videoclubat.videoclubat.entity.Client;

import java.util.List;

public interface IClientServicesDAO {

    List<Client> getAllClients();
    ClientDTO getClientById(int id);
}
