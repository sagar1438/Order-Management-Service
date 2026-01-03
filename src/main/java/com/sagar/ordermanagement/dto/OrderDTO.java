package com.sagar.ordermanagement
.dto;

import com.sagar.ordermanagement
.dto.responses.ClientResponseDTO;
import com.sagar.ordermanagement
.entities.Order;
import com.sagar.ordermanagement
.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private ClientResponseDTO client;
    private List<OrderItemDTO> items = new ArrayList<>();
    private Double getTotal;

    public OrderDTO(Order order) {
        id = order.getId();
        moment = order.getMoment();
        status = order.getStatus();
        client = new ClientResponseDTO(order.getClient());
        order.getItems().forEach(item -> this.items.add(new OrderItemDTO(item)));
        getTotal = order.getTotal();
    }
}

