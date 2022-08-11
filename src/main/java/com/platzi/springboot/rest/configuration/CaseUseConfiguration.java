package com.platzi.springboot.rest.configuration;

import com.platzi.springboot.rest.caseUse.GetUser;
import com.platzi.springboot.rest.caseUse.GetUserImplement;
import com.platzi.springboot.rest.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService ) {
        return new GetUserImplement( userService );
    }
}
