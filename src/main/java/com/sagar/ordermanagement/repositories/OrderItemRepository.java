package com.sagar.ordermanagement
.repositories;
 
import com.sagar.ordermanagement
.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
