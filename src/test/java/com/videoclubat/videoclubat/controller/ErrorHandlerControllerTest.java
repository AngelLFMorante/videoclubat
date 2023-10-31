package com.videoclubat.videoclubat.controller;

import com.videoclubat.videoclubat.services.exception.ApiError;
import com.videoclubat.videoclubat.services.exception.clientexception.ClientBadRequestException;
import com.videoclubat.videoclubat.services.exception.clientexception.ClientNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class ErrorHandlerControllerTest {

    @InjectMocks
    private ErrorHandlerController errorHandlerController;
    @Mock
    private ClientNotFoundException clientNotFoundException;
    @Mock
    private ClientBadRequestException clientBadRequestException;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void clientByIdNotFound() {
        when(clientNotFoundException.getMessage()).thenReturn("Client not found");

        ApiError error = errorHandlerController.clientByIdNotFound(clientNotFoundException);

        assertNotNull(error);
        assertEquals("Client not found", error.getMessage());
        verify(clientNotFoundException).getMessage();
    }

    @Test
    void clientIdBadRequest() {
        when(clientBadRequestException.getMessage()).thenReturn("Cient id bad request");

        ApiError error = errorHandlerController.clientIdBadRequest(clientBadRequestException);

        assertNotNull(error);
        assertEquals("Cient id bad request", error.getMessage());
        verify(clientBadRequestException).getMessage();
    }
}