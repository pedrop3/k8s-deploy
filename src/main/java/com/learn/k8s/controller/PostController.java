package com.learn.k8s.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.k8s.dto.PostDTO;
import com.learn.k8s.entity.Post;
import com.learn.k8s.service.PostService;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    private final ModelMapper mapper; // Criar um bean

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getMethodName(@PathVariable Long id) {
        return ResponseEntity.ok().body(mapper.map(this.postService.findById(id), PostDTO.class));
    }

    @PostMapping
    public ResponseEntity<PostDTO> save(@RequestBody PostDTO postDTO) {

        if (postDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        Post post = mapper.map(postDTO, Post.class);
        post = postService.save(post);
    
        return ResponseEntity.ok().body(mapper.map(post, PostDTO.class));
    }

}
