package com.matheuscardoso.course.repositories;

import com.matheuscardoso.course.entities.Category;
import com.matheuscardoso.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
