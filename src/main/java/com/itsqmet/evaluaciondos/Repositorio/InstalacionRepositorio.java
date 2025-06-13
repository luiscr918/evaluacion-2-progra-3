package com.itsqmet.evaluaciondos.Repositorio;

import com.itsqmet.evaluaciondos.Entidad.Instalacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InstalacionRepositorio extends JpaRepository<Instalacion, Long> {
    List<Instalacion> findByNombreContainingIgnoreCase(String nombre);

}
