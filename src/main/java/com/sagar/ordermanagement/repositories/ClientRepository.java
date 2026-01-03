package com.sagar.ordermanagement
.repositories;

import com.sagar.ordermanagement
.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
