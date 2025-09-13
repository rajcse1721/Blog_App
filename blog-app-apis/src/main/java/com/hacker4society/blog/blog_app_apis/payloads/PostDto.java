package com.hacker4society.blog.blog_app_apis.payloads;

import com.hacker4society.blog.blog_app_apis.entities.Category;
import com.hacker4society.blog.blog_app_apis.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer Id;
    private String title;
    private String contents;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
}
