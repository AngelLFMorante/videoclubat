package com.videoclubat.videoclubat.controller;

import com.videoclubat.videoclubat.services.exception.ApiError;
import com.videoclubat.videoclubat.services.exception.clientexception.ClientBadRequestException;
import com.videoclubat.videoclubat.services.exception.clientexception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandlerController {

    /*
     * START CLIENT DATA EXCEPTION
     */

    /*
    En la anotacion de @ExceptionHandler, vamos a especificar el tipo de excepcion
    que queremos que sea capturado.
     */
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ApiError clientByIdNotFound(ClientNotFoundException cex){
        return new ApiError(LocalDateTime.now(), cex.getMessage());
    }

    @ExceptionHandler(ClientBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiError clientIdBadRequest(ClientBadRequestException cex){
        return new ApiError(LocalDateTime.now(), cex.getMessage());
    }

    /*
     * END CLIENT DATA EXCEPTION
     */

}
