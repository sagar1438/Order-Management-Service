package com.sagar.ordermanagement
.repositories;

import com.sagar.ordermanagement
.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
