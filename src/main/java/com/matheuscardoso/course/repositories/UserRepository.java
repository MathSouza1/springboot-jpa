package com.matheuscardoso.course.repositories;

import com.matheuscardoso.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
