package com.matheuscardoso.course.repositories;

import com.matheuscardoso.course.domain.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
