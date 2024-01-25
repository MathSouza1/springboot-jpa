package com.matheuscardoso.course.services;

import com.matheuscardoso.course.domain.dto.UserDTO;
import com.matheuscardoso.course.entities.User;
import com.matheuscardoso.course.repositories.UserRepository;
import com.matheuscardoso.course.services.exceptions.DatabaseException;
import com.matheuscardoso.course.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return user.orElseThrow(() -> new UserNotFoundException(id));
    }

    public User save(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try{
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, UserDTO userDTO) {
        User user = userRepository.getReferenceById(id);
        updateUserData(user, userDTO);
        return userRepository.save(user);
    }

    private void updateUserData(User user, UserDTO userDTO) {
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPhone(userDTO.phone());
    }
}
