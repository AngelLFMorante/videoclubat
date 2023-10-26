package com.videoclubat.videoclubat.utils;

import com.videoclubat.videoclubat.entity.Client;

import java.util.Optional;

public class Data {

    public static Optional<Client> getAllClients(){
        Client client = Client.builder()
                .firstname("Angel")
                .surname("Fernandez")
                .address("Avenida de los Planetas, 2")
                .phone("666443322")
                .email("angel@gmail.com")
                .build();

        return Optional.ofNullable(client);
    }
}
