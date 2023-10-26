package com.videoclubat.videoclubat.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "pelicula")
public class Film implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;

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
    private Gender gender;
    @OneToMany(mappedBy = "film")
    private List<Rent> rents;
}
