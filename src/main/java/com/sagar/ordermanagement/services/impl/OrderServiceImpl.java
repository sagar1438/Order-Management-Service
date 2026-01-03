package com.sagar.ordermanagement
.services.impl;

import com.sagar.ordermanagement
.dto.OrderDTO;
import com.sagar.ordermanagement
.entities.Order;
import com.sagar.ordermanagement
.exceptions.OrderNotFoundException;
import com.sagar.ordermanagement
.repositories.OrderRepository;
import com.sagar.ordermanagement
.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findAll();
        return list.stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    @Override
    public OrderDTO findById(Long id) {
        return new OrderDTO(repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id)));
    }

    @Override
    public OrderDTO insert(Order order) {
        var orderSaved = repository.save(order);
        return new OrderDTO(orderSaved);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
