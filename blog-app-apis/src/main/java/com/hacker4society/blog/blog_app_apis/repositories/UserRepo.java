package com.hacker4society.blog.blog_app_apis.repositories;

import com.hacker4society.blog.blog_app_apis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
