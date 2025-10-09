package org.noeotero.bocatas.controller.advice;

import org.noeotero.bocatas.dto.UserDTO;
import org.noeotero.bocatas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public void addCurrentUser(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            UserDTO user = userService.findByUsername(username);
            if (user != null) {
                model.addAttribute("currentUser", user);
            }
        }
    }
}