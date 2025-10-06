package org.noeotero.bocatas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "served_date")
    private LocalDateTime servedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderExtra> extras = new ArrayList<>();

    // Constructors
    public Order() {
        this.orderDate = LocalDateTime.now();
    }

    public Order(User user, Product product) {
        this.user = user;
        this.product = product;
        this.orderDate = LocalDateTime.now();
    }

    public Order(User user, Product product, LocalDateTime orderDate) {
        this.user = user;
        this.product = product;
        this.orderDate = orderDate;
    }
}