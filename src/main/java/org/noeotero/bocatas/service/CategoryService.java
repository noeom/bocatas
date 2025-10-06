package org.noeotero.bocatas.service;

import org.noeotero.bocatas.dto.CategoryDTO;
import org.noeotero.bocatas.mapper.CategoryMapper;
import org.noeotero.bocatas.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.toDtos(categoryRepository.findAllByOrderByIdAsc());
    }

}