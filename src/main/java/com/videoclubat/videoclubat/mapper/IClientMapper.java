package com.videoclubat.videoclubat.mapper;

import com.videoclubat.videoclubat.dto.ClientDTO;
import com.videoclubat.videoclubat.dto.RentDTO;
import com.videoclubat.videoclubat.entity.Client;
import com.videoclubat.videoclubat.entity.Rent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IClientMapper {

    @Mapping(target = "name", source = "firstname")
    @Mapping(target = "lastname", source = "surname")
    ClientDTO mapperClientToDto(Client client);

    @Mapping(target = "title", source = "rent.film.title")
    RentDTO mapperRentToDtoList(Rent rent);
}
