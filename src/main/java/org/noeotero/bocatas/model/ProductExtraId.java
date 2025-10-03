package org.noeotero.bocatas.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductExtraId implements Serializable {

    private Long productId;
    private Long extraId;

    // Constructores
    public ProductExtraId() {}

    public ProductExtraId(Long productId, Long extraId) {
        this.productId = productId;
        this.extraId = extraId;
    }

    // Getters y Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getExtraId() {
        return extraId;
    }

    public void setExtraId(Long extraId) {
        this.extraId = extraId;
    }

    // equals() y hashCode() (IMPORTANTE para claves compuestas)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductExtraId that = (ProductExtraId) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(extraId, that.extraId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, extraId);
    }
}