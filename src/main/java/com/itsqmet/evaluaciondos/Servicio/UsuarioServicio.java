package com.itsqmet.evaluaciondos.Servicio;

import com.itsqmet.evaluaciondos.Entidad.Usuario;
import com.itsqmet.evaluaciondos.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServicio {
@Autowired
private UsuarioRepositorio usuarioRepositorio;
    public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.findAll();
    }


    public Optional<Usuario> buscarUsuarioId(Long id){

        return usuarioRepositorio.findById(id);
    }
    //buscar por nombre
    public List<Usuario> buscarPorNombre(String buscarUsuario){
        if (buscarUsuario==null||buscarUsuario.isEmpty()){
            return usuarioRepositorio.findAll();
        }else{
            return usuarioRepositorio.findByNombreContainingIgnoreCase(buscarUsuario);
        }
    }
    //guardar usuario
    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(Long id){

        usuarioRepositorio.deleteById(id);
    }
}
