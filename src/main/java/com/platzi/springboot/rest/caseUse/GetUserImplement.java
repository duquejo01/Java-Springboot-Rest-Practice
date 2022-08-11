package com.platzi.springboot.rest.caseUse;

import com.platzi.springboot.rest.entity.User;
import com.platzi.springboot.rest.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @Override
    public List<User> getAllPagination(int page, int size) {
        int parsedPagination = page > 1 ? page - 1 : 0;
        return userService.getAllPaginationUsers( parsedPagination, size );
    }
}
