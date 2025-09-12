package com.hacker4society.blog.blog_app_apis.services;

import com.hacker4society.blog.blog_app_apis.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    //Create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //get by id
    void deleteCategory(Integer categoryId);

    //delete
    CategoryDto getCategoryById(Integer categoryId);

    //get all
    List<CategoryDto> getCategories();
}
