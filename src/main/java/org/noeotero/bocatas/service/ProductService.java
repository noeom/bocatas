package org.noeotero.bocatas.service;

import org.noeotero.bocatas.dto.ProductDTO;
import org.noeotero.bocatas.mapper.BeanMapper;
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

    @Autowired
    private BeanMapper mapper;

    // Active products only
    public List<ProductDTO> findAllActive() {
        List<Product> products = productRepository.findByDeletionDateIsNullAndAvailabilityDateBefore(LocalDateTime.now());
        return mapper.toProductDtos(products);
    }

    public List<ProductDTO> getActiveProductsByCategory(Long categoryId) {
        return mapper.toProductDtos(productRepository.findByCategoryIdAndDeletionDateIsNullAndAvailabilityDateBefore(
                categoryId, LocalDateTime.now()));
    }
}