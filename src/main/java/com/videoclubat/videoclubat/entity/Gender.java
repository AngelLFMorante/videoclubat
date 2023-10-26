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
@Table(name = "genero")
public class Gender implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genero")
    private String gender;

    @OneToMany(mappedBy = "gender")
    private List<Film> films;

}
