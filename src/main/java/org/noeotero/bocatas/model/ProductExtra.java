package org.noeotero.bocatas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products_extras")
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

    // Getters y Setters
    public ProductExtraId getId() {
        return id;
    }

    public void setId(ProductExtraId id) {
        this.id = id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}