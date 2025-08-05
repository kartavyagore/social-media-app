package com.kartavya.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kartavya.app.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
