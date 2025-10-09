package org.noeotero.bocatas.controller;

import org.noeotero.bocatas.components.ProductCache;
import org.noeotero.bocatas.dto.UserDTO;
import org.noeotero.bocatas.service.OrderService;
import org.noeotero.bocatas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    @Autowired
    private ProductCache productCache;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/order")
    public String order() {
        return "pages/order/order";
    }

    @GetMapping("/order/select")
    public String select(Model model) {
        // Get all products by category.
        model.addAttribute("productsByCategory", productCache.getProductsByCategory());
        // Forward to view.
        return "pages/order/select";
    }

    @PostMapping("/order/add")
    public String addToOrder(@RequestParam Long productId,
                             @RequestParam(required = false) Long extraId,
                             Authentication authentication) {
        UserDTO user = userService.findByUsername(authentication.getName());
        orderService.createOrder(productId, extraId, user.getId());
        return "redirect:/order";
    }
}
