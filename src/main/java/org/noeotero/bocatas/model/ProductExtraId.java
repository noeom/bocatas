package org.noeotero.bocatas.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode(callSuper=false)
public class ProductExtraId implements Serializable {

    private Long productId;
    private Long extraId;

    // Constructores
    public ProductExtraId() {}

    public ProductExtraId(Long productId, Long extraId) {
        this.productId = productId;
        this.extraId = extraId;
    }
}