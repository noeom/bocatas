package org.noeotero.bocatas.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home() {
        return "login";  // Redirige directamente a login
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}