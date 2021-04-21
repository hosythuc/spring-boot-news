package com.hosythuc.blogv2.service.Impl;

import com.hosythuc.blogv2.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    Iterable<UserEntity> findAll();
    Page<UserEntity> findAll(Pageable pageable);
    Optional<UserEntity> findById(Long id);
    UserEntity save(UserEntity entity);
    void delete(UserEntity entity);
}
