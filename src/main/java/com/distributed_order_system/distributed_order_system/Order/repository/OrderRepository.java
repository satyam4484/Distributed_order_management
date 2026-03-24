package com.distributed_order_system.distributed_order_system.Order.repository;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
