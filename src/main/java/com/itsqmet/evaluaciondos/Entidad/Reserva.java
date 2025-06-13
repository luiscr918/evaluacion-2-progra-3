package com.itsqmet.evaluaciondos.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //relacion de reserva con instalacion
    @ManyToOne
    @JoinColumn(name = "id_instalacion")
    private Instalacion instalacion;
    //relacion de reserva con usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private String descripcion;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha;
    private Double precio;


}
