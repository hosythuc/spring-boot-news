package com.hosythuc.blogv2.service.Impl;

import com.hosythuc.blogv2.model.entity.CategoryEntity;
import com.hosythuc.blogv2.model.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface PostService {
    Iterable<PostEntity> findAll();
    Page<PostEntity> findAll(Pageable pageable);
    Optional<PostEntity> findById(Long id);
    PostEntity save(PostEntity entity);
    void delete(PostEntity entity);
}
