package com.videoclubat.videoclubat.repository;

import com.videoclubat.videoclubat.entity.Film;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFilmRepository extends ListCrudRepository<Film, Long> {
    List<Film> findAll();
}
