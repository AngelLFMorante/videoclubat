package com.videoclubat.videoclubat.utils;

import com.videoclubat.videoclubat.dto.ClientDTO;
import com.videoclubat.videoclubat.entity.Client;
import com.videoclubat.videoclubat.mapper.IClientMapper;
import com.videoclubat.videoclubat.mapper.IClientMapperImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Data {

    private static final IClientMapper mapper = new IClientMapperImpl();

    public static Client getClient(){
       return Client.builder()
                .id(2L)
                .firstname("Jose")
                .surname("Garcia Parra")
                .address("Avenida Europa, 17")
                .phone("678998877")
                .email("JoseGP@gmail.com")
                .build();
    }

    public static Optional<Client> getOptionalClient(){
        return Optional.of(getClient());
    }

    public static ClientDTO getClientDTO(){
        return mapper.mapperClientToDto(getClient());
    }

    public static List<ClientDTO> getClientsListDTO(){
        List<ClientDTO> clients = new ArrayList<>();
        clients.add(getClientDTO());
        return clients;
    }

    public static List<Client> getClientsList(){
        List<Client> clients = new ArrayList<>();
        clients.add(getClient());
        return clients;
    }

}
