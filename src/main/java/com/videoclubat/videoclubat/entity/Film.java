package com.videoclubat.videoclubat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pelicula")
@JsonIgnoreProperties("rents")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String title;
    @Column(name = "idioma")
    private String language;
    @Column(name = "duracion")
    private String duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero", nullable = false)
    @JsonBackReference
    private Gender gender;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "film"
    )
    @JsonManagedReference
    private List<Rent> rents;
}
