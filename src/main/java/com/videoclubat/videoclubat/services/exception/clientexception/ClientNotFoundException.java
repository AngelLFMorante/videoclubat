package com.videoclubat.videoclubat.services.exception.clientexception;

import java.io.Serial;

public class ClientNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public ClientNotFoundException(Long id) {
        super("Client with id: " + id + ",  not found");
    }
}
