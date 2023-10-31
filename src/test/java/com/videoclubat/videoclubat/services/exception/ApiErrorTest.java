package com.videoclubat.videoclubat.services.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ApiErrorTest {

    @InjectMocks
    private ApiError apiError;

    @BeforeEach
    void setUp() {
        apiError = new ApiError(LocalDateTime.now(), "message");
    }

    @Test
    void getDate() {
        LocalDateTime date = apiError.getDate();
        assertNotNull(date);
        assertEquals(LocalDateTime.now().getDayOfMonth(), date.getDayOfMonth());
    }

    @Test
    void getMessage() {
        String message = apiError.getMessage();

        assertNotNull(message);
        assertEquals("message", message);
    }
}