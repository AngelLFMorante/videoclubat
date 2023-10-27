package com.videoclubat.videoclubat.controller;

import com.videoclubat.videoclubat.entity.Client;
import com.videoclubat.videoclubat.services.impl.ClientServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/videoclub")
@Slf4j
public class ClientController {
    final static Logger logger = LoggerFactory.getLogger(ClientServicesImpl.class);

    @Autowired
    private ClientServicesImpl services;

    public ClientController(ClientServicesImpl services) {
        this.services = services;
    }

    @GetMapping("/clients")
    private ResponseEntity<Object> getAllClients(){
        logger.debug("Controller, call method getAllClients");
        return new ResponseEntity<>(services.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    private ResponseEntity<Object> getClientById(@PathVariable int id){
        logger.debug("Controller, call method getClientById with id is: ", id);
        Optional<Client> client = services.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
