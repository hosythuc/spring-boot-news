package com.hosythuc.blogv2.model.repo;

import com.hosythuc.blogv2.model.entity.CategoryEntity;
import com.hosythuc.blogv2.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Page<CategoryEntity> findAll(Pageable pageable);
}
