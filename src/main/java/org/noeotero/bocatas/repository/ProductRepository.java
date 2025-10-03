package org.noeotero.bocatas.repository;

import org.noeotero.bocatas.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Buscar productos activos (no borrados)
    List<Product> findByDeletionDateIsNull();

    List<Product> findByCategoryIdAndDeletionDateIsNullAndAvailabilityDateBefore(Long categoryId, LocalDateTime time);

    List<Product> findByDeletionDateIsNullAndAvailabilityDateBefore(LocalDateTime time);
}