package org.noeotero.bocatas.repository;

import org.noeotero.bocatas.model.OrderExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderExtraRepository extends JpaRepository<OrderExtra, Long> {

}