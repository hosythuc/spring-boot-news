package com.hosythuc.blogv2.model.repo;

import com.hosythuc.blogv2.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAll();

    Page<UserEntity> findAll(Pageable pageable);

    UserEntity findByUserName(String username);
}
