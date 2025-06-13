package com.itsqmet.evaluaciondos.Servicio;

import com.itsqmet.evaluaciondos.Entidad.Instalacion;
import com.itsqmet.evaluaciondos.Entidad.Usuario;
import com.itsqmet.evaluaciondos.Repositorio.InstalacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InstalacionServicio {
@Autowired
private InstalacionRepositorio instalacionRepositorio;
    public List<Instalacion> mostrarInstalaciones(){

        return instalacionRepositorio.findAll();
    }

    public List<Instalacion> buscarInstalacionNombre(String buscarInstalacion){
        if(buscarInstalacion==null || buscarInstalacion.isEmpty()){
            return instalacionRepositorio.findAll();
        }else{
            return instalacionRepositorio.findByNombreContainingIgnoreCase(buscarInstalacion);
        }
    }

    public Optional<Instalacion> buscarInstalacionId(Long id){

        return instalacionRepositorio.findById(id);
    }
    //buscar por nombre
    public List<Instalacion> buscarPorNombre(String buscarInstalacion){
        if (buscarInstalacion==null||buscarInstalacion.isEmpty()){
            return instalacionRepositorio.findAll();
        }else{
            return instalacionRepositorio.findByNombreContainingIgnoreCase(buscarInstalacion);
        }
    }
    //guardar instalacion
    public Instalacion guardarInstalacion(Instalacion instalacion){
        return instalacionRepositorio.save(instalacion);
    }




    public void eliminarInstalacion(Long id){

        instalacionRepositorio.deleteById(id);
    }
}
