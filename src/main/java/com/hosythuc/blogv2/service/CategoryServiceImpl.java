package com.hosythuc.blogv2.service;

import com.hosythuc.blogv2.model.entity.CategoryEntity;
import com.hosythuc.blogv2.model.repo.CategoryRepository;
import com.hosythuc.blogv2.service.Impl.CategoryService;
import com.hosythuc.blogv2.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Iterable<CategoryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<CategoryEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public CategoryEntity save(CategoryEntity entity) {
        entity.setSlug(Utils.toSlug(entity.getTitle()));
        entity = repository.save(entity);
        entity.setSlug(Utils.toSlug(entity.getTitle()) + "-" + entity.getId());
        return repository.save(entity);
    }

    @Override
    public void delete(CategoryEntity entity) {
        repository.delete(entity);
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return repository.findById(id);
    }
}
