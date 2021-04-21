package com.hosythuc.blogv2.model.repo;

import com.hosythuc.blogv2.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
