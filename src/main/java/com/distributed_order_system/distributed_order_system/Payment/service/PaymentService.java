package com.distributed_order_system.distributed_order_system.Payment.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Payment.entity.Payment;

public interface PaymentService {
    Payment create(Payment payment);
    Payment update(Long id, Payment payment);
    void delete(Long id);
    Payment getById(Long id);
    List<Payment> getAll();
    Payment getByOrderId(Long orderId);
}
