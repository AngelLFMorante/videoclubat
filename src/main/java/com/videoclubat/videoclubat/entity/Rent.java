package com.videoclubat.videoclubat.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Builder
@Entity
@Table(name = "alquiler")
public class Rent implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pelicula", nullable = false)
    private Film film;

    @Column(name = "alquilado")
    private boolean rented;
    @Column(name = "fecha_entrega")
    private Timestamp deliveryDate;
    @Column(name = "fecha_devolucion")
    private Timestamp returnDate;

}
