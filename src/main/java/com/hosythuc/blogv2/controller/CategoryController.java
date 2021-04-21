package com.hosythuc.blogv2.controller;

import com.hosythuc.blogv2.model.entity.CategoryEntity;
import com.hosythuc.blogv2.service.Impl.CategoryService;
import com.hosythuc.blogv2.util.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Information.API_VERSION + "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("")
    public ResponseEntity<Page<CategoryEntity>> getALlCategory(@RequestParam(value = "page", required = false) Integer page,
                                                               @RequestParam(value = "limit", required = false) Integer limit) {
        if (page == null || limit == null) {
            return new ResponseEntity<>(service.findAll(PageRequest.of(0, Integer.MAX_VALUE)), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.findAll(PageRequest.of(page, limit)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> findCategory(@PathVariable("id") Long id) {
        Optional<CategoryEntity> optional = service.findById(id);
        return optional.map(entity -> {
            return new ResponseEntity(entity, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<CategoryEntity> addCategory(@RequestBody CategoryEntity entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<CategoryEntity> editCategory(@RequestBody CategoryEntity entity) {
        Optional<CategoryEntity> categoryEntity = service.findById(entity.getId());
        return categoryEntity.map(category -> {
            entity.setId(category.getId());
            return new ResponseEntity<>(service.save(entity), HttpStatus.OK);
        }).orElseGet(()->  new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryEntity> deleteCategory(@PathVariable("id") Long id) {
        Optional<CategoryEntity> optional = service.findById(id);
        return optional.map(entity -> {
            service.delete(entity);
            return new ResponseEntity<>(entity, HttpStatus.GONE);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
