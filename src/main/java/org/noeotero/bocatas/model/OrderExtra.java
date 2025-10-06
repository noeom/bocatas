package org.noeotero.bocatas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders_extras")
@Data
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
}