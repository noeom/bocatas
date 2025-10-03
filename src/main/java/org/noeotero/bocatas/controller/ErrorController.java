package org.noeotero.bocatas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/nope")
    public String denied() {
        return "denied";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
