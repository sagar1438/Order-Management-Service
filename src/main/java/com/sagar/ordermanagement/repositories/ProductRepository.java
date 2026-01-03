package com.sagar.ordermanagement
.repositories;

import com.sagar.ordermanagement
.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
