package com.matheuscardoso.course.repositories;

import com.matheuscardoso.course.entities.Category;
import com.matheuscardoso.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
