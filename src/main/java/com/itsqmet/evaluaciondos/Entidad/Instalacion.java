package com.itsqmet.evaluaciondos.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Instalacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //relacion de instalacion a  reserva
    @OneToMany(mappedBy = "instalacion",fetch = FetchType.LAZY)
    private List<Reserva> reservas;
    private String nombre;
    private int capacidad;
    private String descripcion;

}
