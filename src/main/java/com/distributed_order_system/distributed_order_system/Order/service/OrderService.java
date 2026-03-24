package com.distributed_order_system.distributed_order_system.Order.service;

import com.distributed_order_system.distributed_order_system.Order.dto.OrderCreateRequest;
import com.distributed_order_system.distributed_order_system.Order.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse create(OrderCreateRequest orderCreateRequest, Long userId);
    void delete(Long id);
    OrderResponse getById(Long id);
    List<OrderResponse> getAll();
    List<OrderResponse> getByUserId(Long userId);
}
