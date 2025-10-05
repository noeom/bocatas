package org.noeotero.bocatas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
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

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getServedDate() {
        return servedDate;
    }

    public void setServedDate(LocalDateTime servedDate) {
        this.servedDate = servedDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Métodos helper para el estado del pedido
    public boolean isServed() {
        return servedDate != null;
    }

    public void markAsServed() {
        this.servedDate = LocalDateTime.now();
    }

    public List<OrderExtra> getExtras() {
        return extras;
    }

    public void setExtras(List<OrderExtra> extras) {
        this.extras = extras;
    }
}