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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "post id", postId));
        post.setTitle(postDto.getTitle());
        post.setContents(postDto.getContents());
        post.setImageName(postDto.getImageName());

        Post updatedpost = this.postRepo.save(post);
        return this.modelMapper.map(updatedpost,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "post Id", postId));
        this.postRepo.delete(post);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> allPosts = this.postRepo.findAll();
        List<PostDto> postDtos = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "post Id", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "category Id", categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "user Id", userId));
        List<Post> posts = this.postRepo.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }
}
