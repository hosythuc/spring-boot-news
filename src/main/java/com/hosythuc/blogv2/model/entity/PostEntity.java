package com.hosythuc.blogv2.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class PostEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "slug")
    private String slug;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable=false)
    private UserEntity user;

}
