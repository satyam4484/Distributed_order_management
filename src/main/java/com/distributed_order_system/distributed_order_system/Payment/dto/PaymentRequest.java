package com.distributed_order_system.distributed_order_system.Payment.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long orderId;
    private double amount;
    private String paymentMethod;
}
