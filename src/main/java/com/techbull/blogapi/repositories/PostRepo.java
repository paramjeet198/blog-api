package com.techbull.blogapi.repositories;

import com.techbull.blogapi.entities.Category;
import com.techbull.blogapi.entities.Post;
import com.techbull.blogapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PostRepo extends JpaRepository<Post, Integer> {

    @Query(value = "Select * from post where user_id =:userId", nativeQuery = true)
    Set<Post> findByUserId(Integer userId);

    Set<Post> findByCategory(Category category);

}
