package com.videoclubat.videoclubat.services;

import com.videoclubat.videoclubat.entity.Client;

import java.util.List;
import java.util.Optional;

public interface IClientServicesDAO {

    List<Client> getAllClients();
    Optional<Client> getClientById(int id);
}
