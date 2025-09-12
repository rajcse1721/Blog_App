package com.hacker4society.blog.blog_app_apis.impl;

import com.hacker4society.blog.blog_app_apis.entities.Category;
import com.hacker4society.blog.blog_app_apis.entities.Post;
import com.hacker4society.blog.blog_app_apis.entities.User;
import com.hacker4society.blog.blog_app_apis.exceptions.ResourceNotFoundException;
import com.hacker4society.blog.blog_app_apis.payloads.PostDto;
import com.hacker4society.blog.blog_app_apis.repositories.CategoryRepo;
import com.hacker4society.blog.blog_app_apis.repositories.PostRepo;
import com.hacker4society.blog.blog_app_apis.repositories.UserRepo;
import com.hacker4society.blog.blog_app_apis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "user id", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "category id", categoryId));
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("Default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPost() {
        return List.of();
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }
}
