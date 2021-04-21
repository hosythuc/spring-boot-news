package com.hosythuc.blogv2.controller;

import com.hosythuc.blogv2.model.entity.UserEntity;
import com.hosythuc.blogv2.service.Impl.UserService;
import com.hosythuc.blogv2.util.Information;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(Information.API_VERSION +"/users")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserService.class.getSimpleName());

    @Autowired
    private UserService service;

    @PostMapping("")
    public ResponseEntity<UserEntity> addUser(@Valid @RequestBody UserEntity entity){
       System.out.println(entity.toString());
        return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<Page<UserEntity>> getListUsers(@RequestParam(value = "page", required = false) Integer page,
                                                         @RequestParam(value = "limit", required = false) Integer limit) {
        if (page == null || limit == null) {
            return new ResponseEntity<>(service.findAll(PageRequest.of(0, Integer.MAX_VALUE)), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.findAll(PageRequest.of(page, limit)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> editUser(@Valid @PathVariable Long id, @Valid @RequestBody UserEntity entity) {
        Optional<UserEntity> userEntity = service.findById(id);
        return userEntity.map(user -> {
            entity.setId(user.getId());
            return new ResponseEntity<>(service.save(entity), HttpStatus.OK);
        }).orElseGet(()->  new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@Valid @PathVariable Long id) {
        Optional<UserEntity> userEntity = service.findById(id);
        return userEntity.map(user -> {
            service.delete(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }).orElseGet(()->  new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
