package org.noeotero.bocatas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders_extras")
public class OrderExtra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;

    // Referencia individual al producto (para consultas más fáciles)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", nullable = false, insertable = false, updatable = false)
    private Product product;

    // Referencia individual al extra (para consultas más fáciles)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_extra", nullable = false, insertable = false, updatable = false)
    private Extra extra;

    // Referencia a la combinación específica producto-extra (para obtener el precio)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "id_product", referencedColumnName = "id_product", nullable = false),
            @JoinColumn(name = "id_extra", referencedColumnName = "id_extra", nullable = false)
    })
    private ProductExtra productExtra;

    // Constructors
    public OrderExtra() {}

    public OrderExtra(Order order, ProductExtra productExtra) {
        this.order = order;
        this.productExtra = productExtra;
        this.product = productExtra.getProduct();
        this.extra = productExtra.getExtra();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public ProductExtra getProductExtra() {
        return productExtra;
    }

    public void setProductExtra(ProductExtra productExtra) {
        this.productExtra = productExtra;
        if (productExtra != null) {
            this.product = productExtra.getProduct();
            this.extra = productExtra.getExtra();
        }
    }

    // Método helper para obtener el precio del extra en este contexto
    public int getPrice() {
        return productExtra != null ? productExtra.getPrice() : 0;
    }
}