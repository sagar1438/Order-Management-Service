package com.sagar.ordermanagement
.services;

import com.sagar.ordermanagement
.dto.OrderDTO;
import com.sagar.ordermanagement
.entities.Order;
import java.util.List;


public interface OrderService {

    List<OrderDTO> findAll();

    OrderDTO findById(Long id);

    OrderDTO insert(Order order);

    void delete(Long id);
}




