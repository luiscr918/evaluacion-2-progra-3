package com.itsqmet.evaluaciondos.Repositorio;

import com.itsqmet.evaluaciondos.Entidad.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva,Long> {
    List<Reserva> findByFecha(Date fecha);

}
