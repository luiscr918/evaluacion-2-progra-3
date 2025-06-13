package com.itsqmet.evaluaciondos.Controlador;

import com.itsqmet.evaluaciondos.Entidad.Usuario;
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
public class UsuarioController {
@Autowired
private UsuarioServicio usuarioServicio;
    //Leer los usuarios
    @GetMapping("/usuarios")
    public String listarUsuarios(@RequestParam(name="buscarUsuario",required = false,defaultValue = "")
                               String buscarUsuario, Model model){
        List<Usuario> usuarios = usuarioServicio.buscarPorNombre(buscarUsuario);
        model.addAttribute("buscarUsuario",buscarUsuario);
        model.addAttribute("usuarios",usuarios);
        return "Usuario/listaUsuario";
    }
    //Insertar un Nuevo usuario
    @GetMapping("/formularioUsuario")
    public String formularioUsuario(Model model){

        model.addAttribute("usuario", new Usuario());
        return "Usuario/formulario";
    }
    @PostMapping("/guardar-usuario")
    public String guardarLibro(Usuario usuario){
        usuarioServicio.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }
    //Actualizar Usuario
    @GetMapping("/editar-usuario/{id}")
    public String actualizarUsuario(@PathVariable Long id, Model model){
        Optional<Usuario> usuario = usuarioServicio.buscarUsuarioId(id);
        model.addAttribute("usuario", usuario);
        return "Usuario/formulario";
    }
    //Eliminar Usuario
    @GetMapping("/eliminar-usuario/{id}")
    public String eliminarUsuario(@PathVariable Long id){
        usuarioServicio.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}
//metodo para pdf
    /*@GetMapping("/librosPDF")
    public void exportarPDF(HttpServletResponse response )throws IOException, DocumentException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=libros.pdf");
        List<Libro> libros = libroServicio.mostrarLibros();
        Document documento = new Document();
        PdfWriter.getInstance(documento, response.getOutputStream());
        documento.open();
        documento.add(new Paragraph("Listado de Libros"));
        documento.add(new Paragraph(" "));
        for (Libro libro : libros ){
            documento.add(new Paragraph(libro.getId() + " - " + libro.getTitulo() + " - " + libro.getAutor().getNombre()));
        }
        documento.close();
    }

     */
