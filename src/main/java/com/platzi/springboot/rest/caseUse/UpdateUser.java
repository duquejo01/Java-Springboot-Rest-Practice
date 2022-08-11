package com.platzi.springboot.rest.caseUse;

import com.platzi.springboot.rest.entity.User;
import com.platzi.springboot.rest.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User user, Long id) {
        return userService.update( user, id);
    }
}
