package com.distributed_order_system.distributed_order_system.Payment.repository;

import java.util.Optional;

import com.distributed_order_system.distributed_order_system.Payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByOrderId(Long orderId);
}
