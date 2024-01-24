package com.matheuscardoso.course.config;

import com.matheuscardoso.course.entities.User;
import com.matheuscardoso.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User firstUser = new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User secondUser = new User(2L, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(firstUser, secondUser));
    }
}
