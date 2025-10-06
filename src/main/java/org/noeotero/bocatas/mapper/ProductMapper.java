package org.noeotero.bocatas.mapper;

import org.mapstruct.Mapper;
import org.noeotero.bocatas.dto.ProductDTO;
import org.noeotero.bocatas.model.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product entity);
    Product toEntity(ProductDTO dto);
    List<ProductDTO> toDtos(List<Product> entities);
}
