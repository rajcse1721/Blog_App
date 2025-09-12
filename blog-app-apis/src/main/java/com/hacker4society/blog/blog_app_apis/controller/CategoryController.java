package com.hacker4society.blog.blog_app_apis.controller;

import com.hacker4society.blog.blog_app_apis.payloads.ApiResponse;
import com.hacker4society.blog.blog_app_apis.payloads.CategoryDto;
import com.hacker4society.blog.blog_app_apis.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //post-create user
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory( @Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory , HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto CategoryDto , @PathVariable Integer categoryId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(CategoryDto , categoryId);
        return new ResponseEntity<>(updatedCategory , HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("Category deleted successfully !!", true),HttpStatus.OK);
    }

    //Get -single user
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById (@PathVariable Integer categoryId){
        return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));
    }

    //GET -user get
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }
}
