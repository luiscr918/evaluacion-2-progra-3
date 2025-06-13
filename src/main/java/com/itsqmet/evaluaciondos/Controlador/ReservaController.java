package com.itsqmet.evaluaciondos.Controlador;

import com.itsqmet.evaluaciondos.Entidad.Instalacion;
import com.itsqmet.evaluaciondos.Entidad.Reserva;
import com.itsqmet.evaluaciondos.Entidad.Usuario;
import com.itsqmet.evaluaciondos.Servicio.InstalacionServicio;
import com.itsqmet.evaluaciondos.Servicio.ReservaServicio;
import com.itsqmet.evaluaciondos.Servicio.UsuarioServicio;
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
public class ReservaController {
@Autowired
private ReservaServicio reservaServicio;

@Autowired
private InstalacionServicio instalacionServicio;

@Autowired
private UsuarioServicio usuarioServicio;

    //listar todos las facturas de la bd
    @GetMapping("/reservas")
    public String mostrarFacturas(Model model){
        List<Reserva> reservas=reservaServicio.mostrarReservas();
        model.addAttribute("reservas",reservas);
        return "Reserva/listaReservas";
    }
    //Insertar una nueva factura
    //1.amuestro mi form y la nueva factura que ingrese la guardo en la variable factura
    @GetMapping("/formulario/reserva/{id}")
    public String mostrarFormularioReserva(@PathVariable Long id,
                                           Model model){
        // Aquí cargo los objetos de cliente y producto según los IDs
        Optional<Usuario> usuarioOp = usuarioServicio.buscarUsuarioId(id);
        Usuario usuario=usuarioOp.get();
        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        List<Instalacion> instalaciones=instalacionServicio.mostrarInstalaciones();
        model.addAttribute("instalaciones",instalaciones);
        model.addAttribute("reserva", reserva);
        return "Reserva/formulario"; // Tu formulario
    }
    //2.guardo el factura que ingreso
    @PostMapping("/reservas/guardar")
    public String guardarReserva(Reserva reserva){
        reservaServicio.guardarReserva(reserva);
        return "redirect:/reservas";
    }
    //Actualizar el factura
    @GetMapping("/editar/reserva/{id}/{usuarioId}/{instalacionId}")
    public String actualizarFactura(@PathVariable Long id,
                                    @PathVariable Long usuarioId,
                                    @PathVariable Long instalacionId,
                                    Model model){

        Optional<Reserva> reservaOp=reservaServicio.buscarReservaId(id);
        Reserva reserva=reservaOp.get();
        Optional<Usuario>  usuario = usuarioServicio.buscarUsuarioId(usuarioId);
        Optional<Instalacion> instalacion = instalacionServicio.buscarInstalacionId(instalacionId);
        reserva.setUsuario(usuario.get());
        reserva.setInstalacion(instalacion.get());
        model.addAttribute("reserva", reserva);
        return "Reserva/formulario";
    }
    //Eliminar un factura
    @GetMapping("/eliminar/reserva/{id}")
    public String eliminarReserva(@PathVariable Long id){
        reservaServicio.eliminarReserva(id);
        return "redirect:/reservas";
    }
}
