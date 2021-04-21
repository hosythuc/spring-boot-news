package com.hosythuc.blogv2.service;

import com.hosythuc.blogv2.model.entity.PostEntity;
import com.hosythuc.blogv2.model.repo.PostRepository;
import com.hosythuc.blogv2.service.Impl.PostService;
import com.hosythuc.blogv2.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public Iterable<PostEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<PostEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<PostEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PostEntity save(PostEntity entity) {
        entity.setSlug(Utils.toSlug(entity.getTitle()) + "-" + entity.getId());
        return repository.save(entity);
    }

    @Override
    public void delete(PostEntity entity) {
        repository.delete(entity);
    }
}
