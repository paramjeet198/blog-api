package com.techbull.blogapi.services.impl;

import com.techbull.blogapi.entities.Category;
import com.techbull.blogapi.entities.Post;
import com.techbull.blogapi.entities.User;
import com.techbull.blogapi.exceptions.ResourceNotFoundException;
import com.techbull.blogapi.payloads.PostDto;
import com.techbull.blogapi.repositories.CategoryRepo;
import com.techbull.blogapi.repositories.PostRepo;
import com.techbull.blogapi.repositories.UserRepo;
import com.techbull.blogapi.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public PostDto createPost(PostDto postDto, Long userId, Integer categoryId) {//postDto has only 2 properties

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));


        Post post = modelMapper.map(postDto, Post.class);
        post.setImgName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }

    @Override
    public Set<Post> getPostById(Long postId) {
        return null;
    }

    @Override
    public Set<Post> getAllPost() {
        return null;
    }

    @Override
    public Set<Post> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public Set<Post> getPostByUser(Long userId) {
        return null;
    }

    @Override
    public Set<Post> searchPost(String key) {
        return null;
    }
}
