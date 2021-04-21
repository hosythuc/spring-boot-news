package com.hosythuc.blogv2.service.Impl;

import com.hosythuc.blogv2.model.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {
    Iterable<CategoryEntity> findAll();
    Page<CategoryEntity> findAll(Pageable pageable);
    Optional<CategoryEntity> findById(Long id);
    CategoryEntity save(CategoryEntity entity);
    void delete(CategoryEntity entity);
}
