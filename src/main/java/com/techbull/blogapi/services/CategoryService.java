package com.techbull.blogapi.services;

import com.techbull.blogapi.payloads.CategoryDto;

import java.util.List;


public interface CategoryService {


    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto updatedCategory, Integer categoryId);

    void deleteCategory(Integer categoryId);

    CategoryDto getCategory(Integer categoryId);

    List<CategoryDto> getCategories();

}
