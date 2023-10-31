package com.videoclubat.videoclubat.controller;

import com.videoclubat.videoclubat.dto.ClientDTO;
import com.videoclubat.videoclubat.entity.Client;
import com.videoclubat.videoclubat.services.impl.ClientServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/videoclub/v01")
@RequiredArgsConstructor
@Slf4j
public class ClientController {
    final static Logger logger = LoggerFactory.getLogger(ClientController.class);

    private final ClientServicesImpl services;

    @GetMapping("/clients")
    ResponseEntity<Object> getAllClients(){
        logger.info("ClientController, Method: getAllClients - call method getAllClients");
        List<ClientDTO> clients = services.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    ResponseEntity<Object> getClientById(@PathVariable Long id){
        logger.info("ClientController, Method: getClientById - call method getClientById with id is: " + id);
        ClientDTO client = services.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping(value = "/client", produces = {"application/json"}, consumes = {"application/json"})
    ResponseEntity<Object> addNewClient(@Valid @RequestBody Client dataClient){
        logger.info("ClientController, Method: addNewClient - add a new client");
        ClientDTO clientDto = services.addClient(dataClient);
        return new ResponseEntity<>(clientDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/client/{id}", produces = {"application/json"}, consumes = {"application/json"})
    ResponseEntity<Object> editClient(@Valid @PathVariable Long id, @RequestBody Client editClient){
        logger.info("ClientController, Method: editClient - edit client ");
        ClientDTO clientDTO = services.editClient(id, editClient);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/client/{id}")
    ResponseEntity<Object> deleteClient(@PathVariable Long id){
        logger.info("ClientController, Method: deleteClient - delete client ");
        services.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }

}
