package org.noeotero.bocatas.service;

import org.noeotero.bocatas.model.Product;
import org.noeotero.bocatas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Active products only
    public List<Product> findAllActive() {
        return productRepository.findByDeletionDateIsNullAndAvailabilityDateBefore(LocalDateTime.now());
    }

    public List<Product> getActiveProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryIdAndDeletionDateIsNullAndAvailabilityDateBefore(
                categoryId, LocalDateTime.now());
    }
}