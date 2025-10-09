package org.noeotero.bocatas.service;

import org.noeotero.bocatas.dto.CategoryDTO;
import org.noeotero.bocatas.mapper.BeanMapper;
import org.noeotero.bocatas.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BeanMapper mapper;

    public List<CategoryDTO> getAllCategories() {
        return mapper.toCategoryDtos(categoryRepository.findAllByOrderByIdAsc());
    }

}