package org.noeotero.bocatas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products_extras")
@Data
public class ProductExtra {

    @EmbeddedId
    private ProductExtraId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("extraId")
    @JoinColumn(name = "id_extra")
    private Extra extra;

    @Column(name = "price", nullable = false)
    private int price;

    // Constructores
    public ProductExtra() {}

    public ProductExtra(Product product, Extra extra, int price) {
        this.product = product;
        this.extra = extra;
        this.price = price;
        this.id = new ProductExtraId(product.getId(), extra.getId());
    }
}