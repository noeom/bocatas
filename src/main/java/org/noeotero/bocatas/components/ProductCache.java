package org.noeotero.bocatas.components;

import org.noeotero.bocatas.model.Category;
import org.noeotero.bocatas.model.Product;
import org.noeotero.bocatas.model.ProductExtra;
import org.noeotero.bocatas.service.CategoryService;
import org.noeotero.bocatas.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ProductCache {

    private Map<Category, List<Product>> productsByCategory;
    private List<Product> allProducts;

    public ProductCache(ProductService productService, CategoryService categoryService) {
        this.allProducts = productService.findAllActive();
        this.productsByCategory = buildProductsByCategory(categoryService);
    }

    private Map<Category, List<Product>> buildProductsByCategory(CategoryService categoryService) {
        Map<Category, List<Product>> map = new LinkedHashMap<>();

        // Ordenar categorías por ID antes de insertar
        List<Category> sortedCategories = categoryService.getAllCategories().stream()
                .sorted(Comparator.comparing(Category::getId))
                .toList();

        for (Category category : sortedCategories) {
            List<Product> categoryProducts = allProducts.stream()
                    .filter(p -> p.getCategory().getId().equals(category.getId()))
                    .collect(Collectors.toList());
            map.put(category, categoryProducts);
        }
        return map;
    }

    public Map<Category, List<Product>> getProductsByCategory() {
        return Collections.unmodifiableMap(productsByCategory);
    }

    public Product findProductById(Long productId) {
        for (Product product : allProducts) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        throw new RuntimeException("Producto no encontrado: " + productId);
    }

    public ProductExtra findExtraById(Long productId, Long extraId) {
        Product product = findProductById(productId);
        if (product == null) {
            throw new RuntimeException("Producto no encontrado: " + productId);
        }

        for (ProductExtra pe: product.getExtras()) {
            if (pe.getId().getExtraId().equals(extraId)) {
                return pe;
            }
        }
        throw new RuntimeException("Extra no encontrado: " + extraId + " para el producto " + productId);
    }
}
