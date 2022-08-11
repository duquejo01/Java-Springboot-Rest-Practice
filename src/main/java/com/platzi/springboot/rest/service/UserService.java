package com.platzi.springboot.rest.service;

import com.platzi.springboot.rest.entity.User;
import com.platzi.springboot.rest.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOGGER = LogFactory.getLog( UserService.class );
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // If this transaction fails, the application will run a rollback.
    @Transactional
    public void saveTransactional( List<User> users ) {
        users.stream().peek( user -> LOGGER.info( "Inserted user:" + user ) )
                .forEach( userRepository::save ); // JAVA 8 By Reference
                // .forEach( user -> userRepository.save( user ) ); // Another application.
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public List<User> getAllPaginationUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of( page, size )).getContent();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete( new User(id ) );
    }

    public User update(User updateUser, Long id) {
        return userRepository.findById(id).map(
                user -> {
                    user.setEmail( updateUser.getEmail() );
                    user.setBirthDate( updateUser.getBirthDate() );
                    user.setName( updateUser.getName() );
                    return userRepository.save(user);
                }
        ).orElse(null);
    }
}
