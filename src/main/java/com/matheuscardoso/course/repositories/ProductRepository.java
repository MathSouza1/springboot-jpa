package com.matheuscardoso.course.repositories;

import com.matheuscardoso.course.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
