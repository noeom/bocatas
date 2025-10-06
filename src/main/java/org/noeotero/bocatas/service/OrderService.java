package org.noeotero.bocatas.service;

import org.noeotero.bocatas.components.ProductCache;
import org.noeotero.bocatas.dto.UserDTO;
import org.noeotero.bocatas.model.Order;
import org.noeotero.bocatas.model.OrderExtra;
import org.noeotero.bocatas.model.ProductExtra;
import org.noeotero.bocatas.repository.OrderExtraRepository;
import org.noeotero.bocatas.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderExtraRepository orderExtraRepository;
    @Autowired
    private ProductCache productCache;

    @Transactional
    public void createOrder(Long productId, Long extraId, UserDTO user) {
        // 1. Guardar Order
        Order order = new Order(user, productCache.findProductById(productId));
        orderRepository.save(order);

        // 2. Si hay extra, guardar OrderExtra
        if (extraId == null) return;

        ProductExtra productExtra = productCache.findExtraById(productId, extraId);
        OrderExtra orderExtra = new OrderExtra(order, productExtra);
        orderExtraRepository.save(orderExtra);
    }

    public List<Order> getCurrentOrdersForUser(String username) {
        return orderRepository.findByUserUsernameAndServedDateIsNullOrderByOrderDateDesc(username);
    }
}
