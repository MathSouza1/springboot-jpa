package com.matheuscardoso.course.services;

import com.matheuscardoso.course.domain.dto.UserDTO;
import com.matheuscardoso.course.entities.User;
import com.matheuscardoso.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User save(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }
}
