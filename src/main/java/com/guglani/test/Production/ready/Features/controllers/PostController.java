package com.guglani.test.Production.ready.Features.controllers;

import com.guglani.test.Production.ready.Features.dto.PostDto;
import com.guglani.test.Production.ready.Features.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto){
       PostDto postDto1= postService.createPost(postDto);
        return postDto1;
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable Long id){
      return  postService.getPostById(id);
    }

    @GetMapping("/getBulk")
    public List<PostDto> getAllPost(){
      return postService.findAll();
    }

    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable Long id,@RequestBody PostDto body){
        return postService.upatePost(id,body);
    }


}
