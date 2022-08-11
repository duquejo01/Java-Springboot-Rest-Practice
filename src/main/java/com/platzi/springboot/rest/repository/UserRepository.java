package com.platzi.springboot.rest.repository;

import com.platzi.springboot.rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Using JPQL Query
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
