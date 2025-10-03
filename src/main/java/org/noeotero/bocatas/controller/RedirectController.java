package org.noeotero.bocatas.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/redirectByRole")
    public String redirectByRole(Authentication authentication) {

        var roles = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        if (roles.contains("ROLE_ADMIN")) {
            return "redirect:/admin";
        } else if (roles.contains("ROLE_CLIENT")) {
            return "redirect:/order";
        } else if (roles.contains("ROLE_CLASS_MANAGER")) {
            return "redirect:/order";
        } else if (roles.contains("ROLE_SELLER")) {
            return "redirect:/list";
        }

        return "redirect:/login?error"; // fallback
    }
}
