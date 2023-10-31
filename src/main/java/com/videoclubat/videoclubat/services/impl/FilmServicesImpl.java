package com.videoclubat.videoclubat.services.impl;

import com.videoclubat.videoclubat.dto.FilmDTO;
import com.videoclubat.videoclubat.mapper.IFilmMapper;
import com.videoclubat.videoclubat.repository.IFilmRepository;
import com.videoclubat.videoclubat.services.IFilmServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class FilmServicesImpl implements IFilmServices {

    private final IFilmRepository repository;
    private final IFilmMapper mapper;

    @Override
    public List<FilmDTO> getAllFilms() {
        return mapper.filmListMapperToDto(repository.findAll());
    }
}
