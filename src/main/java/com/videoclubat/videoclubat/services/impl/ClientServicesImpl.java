package com.videoclubat.videoclubat.services.impl;

import com.videoclubat.videoclubat.dto.ClientDTO;
import com.videoclubat.videoclubat.entity.Client;
import com.videoclubat.videoclubat.mapper.IClientMapper;
import com.videoclubat.videoclubat.repository.IClientRepository;
import com.videoclubat.videoclubat.services.IClientServices;
import com.videoclubat.videoclubat.services.exception.clientexception.ClientBadRequestException;
import com.videoclubat.videoclubat.services.exception.clientexception.ClientNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional //Marcamos que la clase impl va a ser a nivel transaccional
@Service
@Slf4j
@RequiredArgsConstructor //generamos constructor y nos ahorramos la anotacion @Autowired ( para mi opinion, prefiero constructor)
public class ClientServicesImpl implements IClientServices {

    /*
    Voy a utilizar el logger solo para info para verlo en consola (hay casos que se debería poner debug),
    en caso de error, habrá métodos que se harán en error, pero en esta practica propia lo voy hacer asi.
    */
    final static Logger logger = LoggerFactory.getLogger(ClientServicesImpl.class);

    private final IClientRepository repository;
    private final IClientMapper mapper;

    @Override
    public List<ClientDTO> getAllClients() {
        logger.info("ClientServicesImpl, Method: getAllClients - Llamada para traer todos los clientes");
        /*
        Traemos los datos de la base de datos con repository,
        traemos un objeto de tipo Client
        */
        List<Client> clients = repository.findAll();
        /*
        No vamos a comprobar si viene vacia la lista o null, ya que lo retornamos como un status 200 emptyList
        Por que? porque solo capturamos exception si un unico resultado no hay datos
         */
        logger.info("ClientServicesImpl, Method: getAllClients - Mapeamos datos de los clientes a DTO");
        /*
        Creamos un Objeto de tipo List y con los datos extraidos del repository vamos
        a mappear sus datos para enviar al usuario un Objeto tipo ClientDTO
         */
        List<ClientDTO> clientsDto = new ArrayList<>();
        clients.forEach(c-> {
            clientsDto.add(mapper.mapperClientToDto(c));
        });
        return clientsDto;
    }

    @Override
    public ClientDTO getClientById(long id) {
        /*
        Comprobamos los datos que trae el controlador desde el usuario,ç
        Comprobamos que no sea un numero negativo o 0, ya que la base de datos no contempla numeros negativos o 0
         */
        if(id == 0 || id < 0 ){
            logger.error("ClientServicesImpl, Method: getClientById - La id del usuario es de valor negativo o 0");
            throw new ClientBadRequestException();
        }

        /*
        Llamamos al repository para traer los datos del cliente
        He declarado como Optional la respuesta, me resulta mas comodo detectar valores nulos
        También podría haber remarcado repostory.findById(id).orElse(null), o lanzar exception
        Cada servicio de los 4 se hace de forma distinta para ver varias soluciones.
         */
        Optional<Client> clientFound = repository.findById(id);
        Client client = null;
        //Comprobamos que tenemos cliente en base de datos si no, lanzamos exception
        if(clientFound.isPresent()){
              client = clientFound.get();
        }else{
            logger.error("ClientServicesImpl, Method: getClientById - No existe cliente con id: " + id);
            throw new ClientNotFoundException(id);
        }

        return mapper.mapperClientToDto(client);
    }

}
