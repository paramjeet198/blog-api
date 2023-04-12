package com.techbull.blogapi.controllers;

import com.techbull.blogapi.payloads.ApiResponse;
import com.techbull.blogapi.payloads.CategoryDto;
import com.techbull.blogapi.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    //Create
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }


    //Update
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable int id) {
        CategoryDto updatedCategory = categoryService.updateCategory(categoryDto, id);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(new ApiResponse("Category deleted successfully.", true), HttpStatus.OK);
    }

    //Get
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable int id) {
        CategoryDto categoryDto = categoryService.getCategory(id);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }


    //Get All
    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> categoryDto = categoryService.getCategories();
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }


}
