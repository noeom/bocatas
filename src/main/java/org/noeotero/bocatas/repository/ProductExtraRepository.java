package org.noeotero.bocatas.repository;

import org.noeotero.bocatas.model.ProductExtra;
import org.noeotero.bocatas.model.ProductExtraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductExtraRepository extends JpaRepository<ProductExtra, ProductExtraId> {

}