package org.noeotero.bocatas.service;

import org.noeotero.bocatas.dto.ProductDTO;
import org.noeotero.bocatas.mapper.ProductMapper;
import org.noeotero.bocatas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // Active products only
    public List<ProductDTO> findAllActive() {
        return productMapper.toDtos(productRepository.findByDeletionDateIsNullAndAvailabilityDateBefore(LocalDateTime.now()));
    }

    public List<ProductDTO> getActiveProductsByCategory(Long categoryId) {
        return productMapper.toDtos(productRepository.findByCategoryIdAndDeletionDateIsNullAndAvailabilityDateBefore(
                categoryId, LocalDateTime.now()));
    }
}