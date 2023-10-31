package com.videoclubat.videoclubat.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class RentDTO {

    private String title;
    private boolean rented;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp deliveryDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp returnDate;
}
