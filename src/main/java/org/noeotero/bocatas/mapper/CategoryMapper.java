package org.noeotero.bocatas.mapper;

import org.mapstruct.Mapper;
import org.noeotero.bocatas.dto.CategoryDTO;
import org.noeotero.bocatas.model.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDto(Category category);
    List<CategoryDTO> toDtos(List<Category> categories);
}
