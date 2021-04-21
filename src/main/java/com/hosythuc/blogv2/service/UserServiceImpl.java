package com.hosythuc.blogv2.service;

import com.hosythuc.blogv2.model.entity.UserEntity;
import com.hosythuc.blogv2.model.repo.UserRepository;
import com.hosythuc.blogv2.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    private UserRepository repository;


    @Override
    public Iterable<UserEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<UserEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public UserEntity save(UserEntity entity) {
       // entity = repository.save(entity);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return repository.save(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        repository.delete(entity);
    }
}
