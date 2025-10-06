package org.noeotero.bocatas.dto;

import lombok.Data;
import org.noeotero.bocatas.model.Category;
import org.noeotero.bocatas.model.ProductExtra;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime availabilityDate;
    private LocalDateTime deletionDate;
    private Integer price;
    private Category category;
    private List<ProductExtra> extras;

    // Convenience methos
    private void logicDelete() {
        deletionDate = LocalDateTime.now();
    }
}
