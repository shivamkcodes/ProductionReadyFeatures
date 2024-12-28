package com.guglani.test.Production.ready.Features.services;

import com.guglani.test.Production.ready.Features.dto.PostDto;
import com.guglani.test.Production.ready.Features.entities.Post;
import com.guglani.test.Production.ready.Features.exception.ResourceNotFoundException;
import com.guglani.test.Production.ready.Features.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepo postRepo;

    @Autowired
   ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto) {
       Post post= modelMapper.map(postDto,Post.class);
        System.out.println(post.getDescription());
        postRepo.save(post);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public PostDto getPostById(Long id) {
        boolean post = postRepo.findById(id).isPresent();
        if (!post){
            throw new ResourceNotFoundException("Post Not Found with you");
        }
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> findAll() {
       List<Post> postList= postRepo.findAll();
        return postList.stream()
                .map(e -> modelMapper.map(e,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto upatePost(Long id, PostDto body) {
      boolean isPresent=  postRepo.findById(id).isPresent();
      if (!isPresent){
          throw new ResourceNotFoundException("Post not found ");
      }

      Post post =postRepo.findById(id).get();
      post.setDescription(body.getDescription());
      post.setName(body.getName());

     Post updatedPost= postRepo.save(post);
        return modelMapper.map(updatedPost,PostDto.class);
    }
}
