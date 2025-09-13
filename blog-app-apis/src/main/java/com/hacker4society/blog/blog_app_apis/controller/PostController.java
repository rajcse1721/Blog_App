package com.hacker4society.blog.blog_app_apis.controller;

import com.hacker4society.blog.blog_app_apis.payloads.ApiResponse;
import com.hacker4society.blog.blog_app_apis.payloads.PostDto;
import com.hacker4society.blog.blog_app_apis.services.PostService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    //Create post
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId) {
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {
        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //Get by category
    @GetMapping("category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    //Get all Post
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(){
        List<PostDto> allPost = this.postService.getAllPost();
        return new ResponseEntity<>(allPost,HttpStatus.OK);
    }

    //Get post details by Id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto postById = this.postService.getPostById(postId);
        return  new ResponseEntity<>(postById ,HttpStatus.OK);
    }

    //delete post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ApiResponse("Post deleted successfully !!" , true);
    }

    //update post
    //delete post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto updatedPost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatedPost,HttpStatus.OK);
    }


}
