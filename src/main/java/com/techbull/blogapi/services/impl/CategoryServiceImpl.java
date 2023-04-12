package com.techbull.blogapi.services.impl;

import com.techbull.blogapi.entities.Category;
import com.techbull.blogapi.exceptions.ResourceNotFoundException;
import com.techbull.blogapi.payloads.CategoryDto;
import com.techbull.blogapi.repositories.CategoryRepo;
import com.techbull.blogapi.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category savedCat = categoryRepo.save(category);
        return this.modelMapper.map(savedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto updatedCategory, Integer categoryId) {

        Category odlCategory = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category", categoryId));

        if (StringUtils.hasText(updatedCategory.getCategoryTitle())) {
            odlCategory.setCategoryTitle(updatedCategory.getCategoryTitle());
        }

        if (StringUtils.hasText(updatedCategory.getCategoryDescription())) {
            odlCategory.setCategoryDescription(updatedCategory.getCategoryDescription());
        }

        Category savedCat = categoryRepo.save(odlCategory);
        return this.modelMapper.map(savedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> category = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        category.forEach(cat -> {
            categoryDtos.add(this.modelMapper.map(cat, CategoryDto.class));
        });

        return categoryDtos;
    }
}
