package org.noeotero.bocatas.service;

import org.noeotero.bocatas.components.ProductCache;
import org.noeotero.bocatas.mapper.BeanMapper;
import org.noeotero.bocatas.model.*;
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
    @Autowired
    private BeanMapper mapper;

    @Transactional
    public void createOrder(Long productId, Long extraId, Long userId) {

        // Save product.
        User user = new User();
        user.setId(userId);
        Product product =  new Product();
        product.setId(productId);
        Order order = new Order(user, product);
        orderRepository.save(order);

        // Save extra, if any.
        if (extraId == null) return;

        ProductExtra productExtra = new ProductExtra();
        ProductExtraId peId = new ProductExtraId();
        peId.setExtraId(extraId);
        peId.setProductId(productId);
        Extra extra = new Extra();
        extra.setId(extraId);
        productExtra.setId(peId);
        productExtra.setExtra(extra);
        productExtra.setProduct(product);
        OrderExtra orderExtra = new OrderExtra(order, productExtra);
        orderExtraRepository.save(orderExtra);
    }

    public List<Order> getCurrentOrdersForUser(String username) {
        return orderRepository.findByUserUsernameAndServedDateIsNullOrderByOrderDateDesc(username);
    }
}
