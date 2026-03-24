package com.distributed_order_system.distributed_order_system.Order.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Long productId;
    private int quantity;
}
