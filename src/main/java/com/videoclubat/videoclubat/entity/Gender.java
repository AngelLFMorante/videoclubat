package com.videoclubat.videoclubat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genero")
@JsonIgnoreProperties("films")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genero")
    private String gender;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "gender"

    )
    @JsonManagedReference
    private List<Film> films;

}
