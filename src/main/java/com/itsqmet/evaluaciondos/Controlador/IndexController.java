package com.itsqmet.evaluaciondos.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    //mostrar el index
    @GetMapping("/")
    public String mostrarIndex(){
        return "index";
    }
}
