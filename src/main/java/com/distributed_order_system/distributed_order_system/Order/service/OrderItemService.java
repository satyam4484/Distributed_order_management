package com.distributed_order_system.distributed_order_system.Order.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Order.entity.OrderItem;

public interface OrderItemService {
    OrderItem create(OrderItem item);
    OrderItem update(Long id, OrderItem item);
    void delete(Long id);
    OrderItem getById(Long id);
    List<OrderItem> getAll();
    List<OrderItem> getByOrderId(Long orderId);
    List<OrderItem> getByProductId(Long productId);
}
