package com.distributed_order_system.distributed_order_system.Payment.service;

import com.distributed_order_system.distributed_order_system.Payment.dto.PaymentRequest;
import com.distributed_order_system.distributed_order_system.Payment.dto.PaymentResponse;

import java.util.List;

public interface PaymentService {
    PaymentResponse create(PaymentRequest paymentRequest);
    void delete(Long id);
    PaymentResponse getById(Long id);
    List<PaymentResponse> getAll();
    PaymentResponse getByOrderId(Long orderId);
}
