package com.techbull.blogapi.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "blog_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT", length = 6000)
    private String content;

    private String imgName;
    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

}
