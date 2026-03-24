package com.distributed_order_system.distributed_order_system.Order.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Order.entity.Order;
import com.distributed_order_system.distributed_order_system.Order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        Order existing = orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        existing.setPrice(order.getPrice());
        existing.setStatus(order.getStatus());
        return orderRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
