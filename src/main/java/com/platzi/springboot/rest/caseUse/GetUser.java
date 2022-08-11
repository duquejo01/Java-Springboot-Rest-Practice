package com.platzi.springboot.rest.caseUse;

import com.platzi.springboot.rest.entity.User;

import java.util.List;

public interface GetUser {
    List<User> getAll();
    List<User> getAllPagination( int page, int size );
}
