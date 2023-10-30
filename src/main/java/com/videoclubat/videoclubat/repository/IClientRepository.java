package com.videoclubat.videoclubat.repository;

import com.videoclubat.videoclubat.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClientRepository extends CrudRepository<Client, Long> {

    Optional<Client> findById(Long id);
    List<Client> findAll();
    Client save(Client client);
    void deleteById(Long id);
}
