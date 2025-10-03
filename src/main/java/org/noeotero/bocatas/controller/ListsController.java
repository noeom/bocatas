package org.noeotero.bocatas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListsController {

    @GetMapping("/list")
    public String login() {
        return "lists";
    }
}
