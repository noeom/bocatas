package org.noeotero.bocatas.mapper;

import org.mapstruct.Mapper;
import org.noeotero.bocatas.dto.CategoryDTO;
import org.noeotero.bocatas.dto.ExtraDTO;
import org.noeotero.bocatas.dto.ProductDTO;
import org.noeotero.bocatas.dto.UserDTO;
import org.noeotero.bocatas.model.Category;
import org.noeotero.bocatas.model.Product;
import org.noeotero.bocatas.model.ProductExtra;
import org.noeotero.bocatas.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeanMapper {

    // Categories.
    CategoryDTO toDto(Category category);
    List<CategoryDTO> toCategoryDtos(List<Category> categories);

    // Products.
    ProductDTO toDto(Product entity);
    List<ProductDTO> toProductDtos(List<Product> entities);

    // Products-Extras.
    default ExtraDTO productExtraToExtraDto(ProductExtra entity) {
        ExtraDTO extra = new ExtraDTO();
        extra.setId(entity.getExtra().getId());
        extra.setName(entity.getExtra().getName());
        extra.setDescription(entity.getExtra().getDescription());
        extra.setPrice(entity.getPrice());
        return extra;
    }



    // Users.
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
}
