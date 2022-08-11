package com.platzi.springboot.rest.caseUse;

import com.platzi.springboot.rest.entity.User;
import com.platzi.springboot.rest.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User user) {
        return userService.save( user );
    }
}
