package com.hacker4society.blog.blog_app_apis.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {


    private Integer categoryId;
    @NotEmpty
    @Size(min = 4, message = "Category Title must be min of 4 characters !!")
    private String categoryTitle;
    @NotEmpty
    @Size(min = 10, message = "Category Description must be min of 10 characters !!")
    private String categoryDescription;

}
