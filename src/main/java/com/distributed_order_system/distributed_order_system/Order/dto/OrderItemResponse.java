package com.distributed_order_system.distributed_order_system.Order.dto;

import lombok.Data;

@Data
public class OrderItemResponse {
    private Long id;
    private Long productId;
    private int quantity;
    private double price;
}
