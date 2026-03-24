package com.distributed_order_system.distributed_order_system.Payment.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PaymentResponse {
    private Long id;
    private Long orderId;
    private double amount;
    private String status;
    private String paymentMethod;
    private LocalDateTime transactionTime;
}
