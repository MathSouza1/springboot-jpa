package com.matheuscardoso.course.repositories;

import com.matheuscardoso.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
