package org.noeotero.bocatas.controller;

import org.noeotero.bocatas.model.Category;
import org.noeotero.bocatas.model.Product;
import org.noeotero.bocatas.service.CategoryService;
import org.noeotero.bocatas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/order")
    public String order() {
        return "pages/order/order";
    }

    @GetMapping("/order/select")
    public String select(Model model) {
        // Get categories.
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        // Get all products.
        model.addAttribute("allProducts", productService.findAllActive());
        // Forward to view.
        return "pages/order/select";
    }
}
