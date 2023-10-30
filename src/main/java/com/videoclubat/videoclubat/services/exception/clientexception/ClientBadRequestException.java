package com.videoclubat.videoclubat.services.exception.clientexception;

import java.io.Serial;

public class ClientBadRequestException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public ClientBadRequestException() {
        super("The id is incorrectly");
    }
}
