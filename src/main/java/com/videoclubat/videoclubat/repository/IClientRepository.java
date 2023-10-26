package com.videoclubat.videoclubat.repository;

import com.videoclubat.videoclubat.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IClientRepository extends CrudRepository<Client, Long> {

    Optional<Client> findByAll();
}
