package com.videoclubat.videoclubat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "alquiler")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonBackReference
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pelicula", nullable = false)
    @JsonBackReference
    private Film film;

    @Column(name = "alquilado")
    private boolean rented;
    @Column(name = "fecha_entrega")
    private Timestamp deliveryDate;
    @Column(name = "fecha_devolucion")
    private Timestamp returnDate;

}
