package org.noeotero.bocatas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    // Esta ruta (/demo/login) servirá el maqueto de login
    @GetMapping("/demo/login")
    public String mostrarLoginDemo() {
        // Devuelve el nombre de la plantilla (templates/login-demo.html)
        return "login-demo";
    }

    // Esta ruta (/demo/alumno) servirá el maqueto del dashboard del alumno
    @GetMapping("/demo/alumno")
    public String mostrarAlumnoDemo() {
        // Devuelve el nombre de la plantilla (templates/alumno-demo.html)
        return "alumno-demo";
    }

    // Esta ruta (/demo/admin) servirá el maqueto del panel del dueño
    @GetMapping("/demo/admin")
    public String mostrarAdminDemo() {
        // Devuelve el nombre de la plantilla (templates/admin-demo.html)
        return "admin-demo";
    }
}