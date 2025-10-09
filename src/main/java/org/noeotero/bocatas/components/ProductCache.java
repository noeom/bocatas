package org.noeotero.bocatas.components;

import org.noeotero.bocatas.dto.CategoryDTO;
import org.noeotero.bocatas.dto.ExtraDTO;
import org.noeotero.bocatas.dto.ProductDTO;
import org.noeotero.bocatas.service.CategoryService;
import org.noeotero.bocatas.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ProductCache {

    private Map<CategoryDTO, List<ProductDTO>> productsByCategory;
    private List<ProductDTO> allProducts;

    public ProductCache(ProductService productService, CategoryService categoryService) {
        this.allProducts = productService.findAllActive();
        this.productsByCategory = buildProductsByCategory(categoryService);
    }

    private Map<CategoryDTO, List<ProductDTO>> buildProductsByCategory(CategoryService categoryService) {
        Map<CategoryDTO, List<ProductDTO>> map = new LinkedHashMap<>();

        // Ordenar categorías por ID antes de insertar
        List<CategoryDTO> sortedCategories = categoryService.getAllCategories().stream()
                .sorted(Comparator.comparing(CategoryDTO::getId))
                .toList();

        for (CategoryDTO category : sortedCategories) {
            List<ProductDTO> categoryProducts = allProducts.stream()
                    .filter(p -> p.getCategory().getId().equals(category.getId()))
                    .collect(Collectors.toList());
            map.put(category, categoryProducts);
        }
        return map;
    }

    public Map<CategoryDTO, List<ProductDTO>> getProductsByCategory() {
        return Collections.unmodifiableMap(productsByCategory);
    }

    public ProductDTO findProductById(Long productId) {
        for (ProductDTO product : allProducts) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        throw new RuntimeException("Producto no encontrado: " + productId);
    }

    public ExtraDTO findExtraById(Long productId, Long extraId) {
        ProductDTO product = findProductById(productId);
        if (product == null) {
            throw new RuntimeException("Producto no encontrado: " + productId);
        }

        for (ExtraDTO extra: product.getExtras()) {
            if (extra.getId().equals(extraId)) {
                return extra;
            }
        }
        throw new RuntimeException("Extra no encontrado: " + extraId + " para el producto " + productId);
    }
}
