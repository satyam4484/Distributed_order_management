package com.distributed_order_system.distributed_order_system.Order.dto;

import com.distributed_order_system.distributed_order_system.Order.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private Long userId;
    private List<OrderItemResponse> items;
    private double price;
    private OrderStatus status;
    private LocalDateTime createdAt;
}
