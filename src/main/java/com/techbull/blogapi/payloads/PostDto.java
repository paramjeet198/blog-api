package com.techbull.blogapi.payloads;

import com.techbull.blogapi.entities.Category;
import com.techbull.blogapi.entities.User;
import lombok.Data;

import java.util.Date;

@Data
public class PostDto {

    private String title;
    private String content;

    private String imgName;
    private Date addedDate;

    private CategoryDto category;
    private UserDto user;

}
