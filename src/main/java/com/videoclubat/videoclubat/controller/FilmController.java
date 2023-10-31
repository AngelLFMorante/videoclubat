package com.videoclubat.videoclubat.controller;

import com.videoclubat.videoclubat.dto.FilmDTO;
import com.videoclubat.videoclubat.services.impl.FilmServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videoclub/v01")
@RequiredArgsConstructor
@Slf4j
public class FilmController {

    private final FilmServicesImpl services;

    @GetMapping("/films")
    ResponseEntity<Object> getAllFilms(){
        List<FilmDTO> films = services.getAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }
}
