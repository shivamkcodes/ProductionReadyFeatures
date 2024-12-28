package com.guglani.test.Production.ready.Features.services;

import com.guglani.test.Production.ready.Features.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    public PostDto createPost(PostDto postDto);

    public PostDto getPostById(Long id);

    public List<PostDto> findAll();

    PostDto upatePost(Long id, PostDto body);
}
