package com.learn.k8s.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.k8s.entity.Post;

@Repository
public interface PostRepository  extends JpaRepository<Post,Long>{
    
}
