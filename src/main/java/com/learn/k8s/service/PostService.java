package com.learn.k8s.service;

import com.learn.k8s.entity.Post;

public interface PostService {
    Post save(Post post);
    
    Post findById(Long postId);
}
