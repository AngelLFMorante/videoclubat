package com.videoclubat.videoclubat.mapper;

import com.videoclubat.videoclubat.dto.FilmDTO;
import com.videoclubat.videoclubat.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IFilmMapper {

    List<FilmDTO> filmListMapperToDto(List<Film> films);

    @Mapping(target = "gender", source = "film.gender.gender")
    FilmDTO filmMapperToDto(Film film);
}
