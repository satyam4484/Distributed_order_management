package com.distributed_order_system.distributed_order_system.Order.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Order.entity.Order;

public interface OrderService {
    Order create(Order order);
    Order update(Long id, Order order);
    void delete(Long id);
    Order getById(Long id);
    List<Order> getAll();
    List<Order> getByUserId(Long userId);
}
