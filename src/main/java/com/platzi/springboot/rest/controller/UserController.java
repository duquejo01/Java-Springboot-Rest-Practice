package com.platzi.springboot.rest.controller;

import com.platzi.springboot.rest.caseUse.CreateUser;
import com.platzi.springboot.rest.caseUse.DeleteUser;
import com.platzi.springboot.rest.caseUse.GetUser;
import com.platzi.springboot.rest.caseUse.UpdateUser;
import com.platzi.springboot.rest.entity.User;
import com.platzi.springboot.rest.repository.UserRepository;
import org.hibernate.sql.Update;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CRUD Controller Service
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final GetUser getUser;
    private final CreateUser createUser;
    private final DeleteUser deleteUser;
    private final UpdateUser updateUser;

    public UserController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser ) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping
    public ResponseEntity<List<User>> get() {
        return new ResponseEntity<>(getUser.getAll(), HttpStatus.OK );
    }

    @GetMapping( params = { "page", "size" })
    public ResponseEntity<List<User>> getUserPageable(@RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(getUser.getAllPagination(page, size), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(createUser.save( user ), HttpStatus.CREATED );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        deleteUser.delete( id );
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
        return new ResponseEntity<>(updateUser.update(user, id), HttpStatus.OK );
    }
}
