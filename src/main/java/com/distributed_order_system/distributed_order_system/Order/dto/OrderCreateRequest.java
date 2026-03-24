package com.distributed_order_system.distributed_order_system.Order.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreateRequest {
    private List<OrderItemRequest> items;
}
