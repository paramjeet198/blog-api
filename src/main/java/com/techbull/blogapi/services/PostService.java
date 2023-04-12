package com.techbull.blogapi.services;

import com.techbull.blogapi.entities.Post;
import com.techbull.blogapi.entities.User;
import com.techbull.blogapi.payloads.PostDto;

import java.util.Set;

public interface PostService {

//    Post createPost

    PostDto createPost(PostDto postDto, Long userId, Integer categoryId);

    PostDto updatePost(PostDto postDto, Long postId);

    void deletePost(Long postId);

    Set<Post> getPostById(Long postId);

    Set<Post> getAllPost();

    Set<Post> getPostByCategory(Integer categoryId);

    Set<Post> getPostByUser(Long userId);

    Set<Post> searchPost(String key);


}
