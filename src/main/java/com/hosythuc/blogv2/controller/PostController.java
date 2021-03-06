package com.hosythuc.blogv2.controller;

import com.hosythuc.blogv2.model.entity.PostEntity;
import com.hosythuc.blogv2.model.entity.UserEntity;
import com.hosythuc.blogv2.service.Impl.PostService;
import com.hosythuc.blogv2.service.Impl.UserService;
import com.hosythuc.blogv2.util.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(Information.API_VERSION + "/posts")
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping("")
    public ResponseEntity<Page<PostEntity>> getAllPosts(@RequestParam(value = "page", required = false) Integer page,
                                                        @RequestParam(value = "limit", required = false) Integer limit) {
        if (page == null || limit == null) {
            return new ResponseEntity<>(service.findAll(PageRequest.of(0, Integer.MAX_VALUE)), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.findAll(PageRequest.of(page, limit)), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PostEntity> addPost(@RequestBody PostEntity entity) {
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostEntity> editPost(@PathVariable Long id, @RequestBody PostEntity entity) {
        Optional<PostEntity> optional = service.findById(id);
        return optional.map(entity1 -> {
            entity.setId(id);
            return new ResponseEntity<>(service.save(entity), HttpStatus.ACCEPTED);
        }).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
