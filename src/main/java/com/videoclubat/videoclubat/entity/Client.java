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
@Table(name = "cliente")
public class Client implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
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

    @OneToMany(mappedBy = "client")
    private List<Rent> rents;
}
