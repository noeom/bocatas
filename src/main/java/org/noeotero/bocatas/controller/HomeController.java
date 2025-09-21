package org.noeotero.bocatas.controller;

import org.noeotero.bocatas.model.Grupo;
import org.noeotero.bocatas.repository.GrupoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final GrupoRepository grupoRepository;

    // Inyección de dependencias por constructor (más recomendable que @Autowired)
    public HomeController(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Recuperar todos los grupos de la base de datos
        List<Grupo> grupos = grupoRepository.findAll();
        // Añadir la lista de grupos al modelo para que Thymeleaf la use en la vista
        model.addAttribute("grupos", grupos);
        // Devolver el nombre de la plantilla Thymeleaf (templates/home.html)
        return "home";
    }
}