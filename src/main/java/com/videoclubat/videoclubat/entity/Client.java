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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
//se ingnora porque si no recibimos un error circular : Multiple back-reference properties with name 'defaultReference'
@JsonIgnoreProperties("rents")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String firstname;
    @Column(name = "apellidos")
    private String surname;
    @Column(name = "direccion")
    private String address;
    @Column(name = "telefono")
    private String phone;
    private String email;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "client"
    )
    @JsonManagedReference
    private List<Rent> rents;
}
