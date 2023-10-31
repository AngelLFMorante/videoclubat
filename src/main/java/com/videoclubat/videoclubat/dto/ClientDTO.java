package com.videoclubat.videoclubat.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {

    private String name;
    private String lastname;
    private String phone;
    private List<RentDTO> rents;
}
