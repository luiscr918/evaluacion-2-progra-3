package com.itsqmet.evaluaciondos.Controlador;

import com.itsqmet.evaluaciondos.Entidad.Instalacion;
import com.itsqmet.evaluaciondos.Entidad.Usuario;
import com.itsqmet.evaluaciondos.Servicio.InstalacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class InstalacionController {
    @Autowired
    private InstalacionServicio instalacionServicio;
    //Leer los instalaciones
    @GetMapping("/instalaciones")
    public String listarInstalaciones(@RequestParam(name="buscarInstalacion",required = false,defaultValue = "")
                                 String buscarInstalacion, Model model){
        List<Instalacion> instalaciones = instalacionServicio.buscarPorNombre(buscarInstalacion);
        model.addAttribute("buscarInstalacion",buscarInstalacion);
        model.addAttribute("instalaciones",instalaciones);
        return "Instalacion/listaInstalacion";
    }
    //Insertar un Nuevo instalacion
    @GetMapping("/formularioInstalacion")
    public String formularioInstalacion(Model model){

        model.addAttribute("instalacion", new Instalacion());
        return "Instalacion/formulario";
    }
    @PostMapping("/guardar-instalacion")
    public String guardarInstalacion(Instalacion instalacion){
        instalacionServicio.guardarInstalacion(instalacion);
        return "redirect:/instalaciones";
    }
    //Actualizar Usuario
    @GetMapping("/editar-instalacion/{id}")
    public String actualizarInstalacion(@PathVariable Long id, Model model){
        Optional<Instalacion> instalacion = instalacionServicio.buscarInstalacionId(id);
        model.addAttribute("instalacion", instalacion);
        return "Instalacion/formulario";
    }
    //Eliminar Usuario
    @GetMapping("/eliminar-instalacion/{id}")
    public String eliminarInstalacion(@PathVariable Long id){
        instalacionServicio.eliminarInstalacion(id);
        return "redirect:/instalaciones";
    }
}
