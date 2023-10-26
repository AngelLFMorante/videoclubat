package com.videoclubat.videoclubat.services;

import com.videoclubat.videoclubat.entity.Client;

import java.util.Optional;

public interface IClientServices {

    Optional<Client> getAllClients();
}
