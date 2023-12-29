package com.learn.k8s.service.impl;

import org.springframework.stereotype.Service;

import com.learn.k8s.entity.Post;
import com.learn.k8s.repository.PostRepository;
import com.learn.k8s.service.PostService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findById(Long postId) {
        return postRepository.findById(postId).orElseThrow();
    }
}
