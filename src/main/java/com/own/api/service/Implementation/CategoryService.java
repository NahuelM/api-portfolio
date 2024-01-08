package com.own.api.service.Implementation;

import com.own.api.dto.Entry.CategoryEntryDTO;
import com.own.api.dto.Modify.CategoryModifyDTO;
import com.own.api.dto.Out.CategoryOutDTO;
import com.own.api.model.Category;
import com.own.api.repository.CategoryRepository;
import com.own.api.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);
    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryOutDTO> list() {
        List<CategoryOutDTO> categories = categoryRepository.findAll().stream()
                .map(c -> modelMapper.map(c, CategoryOutDTO.class)).toList();

        LOGGER.info("list of all categories: {}", categories);

        return categories;
    }

    @Override
    public CategoryOutDTO register(CategoryEntryDTO category) {
        Category categorySaved = categoryRepository.save(dtoInToEntity(category));
        CategoryOutDTO categoryOutDTO = modelMapper.map(categorySaved, CategoryOutDTO.class);
        LOGGER.info("Category Saved: {}", categoryOutDTO);
        return categoryOutDTO;
    }

    @Override
    public CategoryOutDTO searchForId(Long id) {
        Category categorySearched = categoryRepository.findById(id).orElse(null);
        CategoryOutDTO categoryOutDTO = null;
        if(categorySearched != null){
            categoryOutDTO = modelMapper.map(categorySearched, CategoryOutDTO.class);
            LOGGER.info("Category: {}", categoryOutDTO);
        }
        else
            LOGGER.error("id not valid for category");
        return categoryOutDTO;
    }

    @Override
    public void delete(Long id) {
        if (searchForId(id) != null) {
            categoryRepository.deleteById(id);
            LOGGER.warn("eliminated category with id: {}", id);
        }
        else {
            LOGGER.error("category not found {}", id);
        }
    }

    @Override
    public CategoryOutDTO update(CategoryModifyDTO category) {
        Category categoryReceived = modelMapper.map(category, Category.class);
        Category categoryToUpdate = categoryRepository.findById(category.getId()).orElse(null);
        CategoryOutDTO categoryOutDTO = null;

        if (categoryToUpdate != null) {

            categoryToUpdate = categoryReceived;
            categoryRepository.save(categoryToUpdate);

            categoryOutDTO = modelMapper.map(categoryToUpdate, CategoryOutDTO.class);

            LOGGER.warn("Category updated: {}", categoryOutDTO);

        } else {
            LOGGER.error("category not registered");

        }
        return categoryOutDTO;
    }

    private Category dtoInToEntity(CategoryEntryDTO categoryEntryDTO) {
        return modelMapper.map(categoryEntryDTO, Category.class);
    }
}
