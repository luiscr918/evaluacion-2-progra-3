package com.itsqmet.evaluaciondos.Servicio;

import com.itsqmet.evaluaciondos.Entidad.Reserva;
import com.itsqmet.evaluaciondos.Repositorio.ReservaRepositorio;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class ReservaServicio {
@Autowired
private ReservaRepositorio reservaRepositorio;
    public List<Reserva> mostrarReservas(){

        return reservaRepositorio.findAll();
    }

    public List<Reserva> buscarReservaFecha(Date buscarFecha){
        if(buscarFecha==null){
            return reservaRepositorio.findAll();
        }else{
            return reservaRepositorio.findByFecha(buscarFecha);
        }
    }

    public Optional<Reserva> buscarReservaId(Long id){

        return reservaRepositorio.findById(id);
    }
//guardar reserva
    public Reserva guardarReserva(Reserva reserva){
        return reservaRepositorio.save(reserva);
    }

    public void eliminarReserva(Long id){

        reservaRepositorio.deleteById(id);
    }
}
