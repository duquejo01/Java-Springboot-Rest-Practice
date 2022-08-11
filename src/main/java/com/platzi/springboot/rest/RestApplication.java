package com.platzi.springboot.rest;

import com.platzi.springboot.rest.entity.User;
import com.platzi.springboot.rest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

	private UserRepository userRepository;

	public RestApplication( UserRepository userRepository ) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Initialize DB
		saveUsers();
	}

	private void saveUsers() {
		User user1 = new User("Sophie", "sophie@email.com", LocalDate.of(2022, 8, 28).toString() );
		User user2 = new User("Sergio", "sergio@email.com", LocalDate.of(2020, 1, 31).toString() );
		User user3 = new User("Jose", "jose@email.com", LocalDate.of(2000, 3, 3).toString() );
		User user4 = new User("Eliana", "eliana@email.com", LocalDate.of(1996, 4, 6).toString() );
		User user5 = new User("Juan", "juan@email.com", LocalDate.of(1995, 7, 12).toString() );
		User user6 = new User("Mario", "mario@email.com", LocalDate.of(1980, 8, 22).toString() );
		User user7 = new User("Michael", "michael@email.com", LocalDate.of(2014, 12, 2).toString() );
		List<User> list = Arrays.asList( user1, user2, user3, user4, user5, user6, user7 );
		userRepository.saveAll(list);
	}
}
