package com.techbull.blogapi.repositories;

import com.techbull.blogapi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
