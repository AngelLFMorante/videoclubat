package com.videoclubat.videoclubat.dto;

import com.videoclubat.videoclubat.entity.Gender;
import lombok.Data;

@Data
public class FilmDTO {

    private String title;
    private String language;
    private String duration;
    private String gender;
}
