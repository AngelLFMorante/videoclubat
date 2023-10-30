package com.videoclubat.videoclubat.controller;

import com.videoclubat.videoclubat.dto.ClientDTO;
import com.videoclubat.videoclubat.services.impl.ClientServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/videoclub/v01")
@RequiredArgsConstructor
@Slf4j
public class ClientController {
    final static Logger logger = LoggerFactory.getLogger(ClientController.class);

    private final ClientServicesImpl services;

    @GetMapping("/clients")
    private ResponseEntity<Object> getAllClients(){
        logger.info("ClientController, Method: getAllClients - call method getAllClients");
        List<ClientDTO> clients = services.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    private ResponseEntity<Object> getClientById(@PathVariable long id){
        logger.info("ClientController, Method: getClientById - call method getClientById with id is: " + id);
        ClientDTO client = services.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
