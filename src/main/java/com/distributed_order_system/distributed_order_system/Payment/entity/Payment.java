package com.distributed_order_system.distributed_order_system.Payment.entity;

import java.time.LocalDateTime;

import com.distributed_order_system.distributed_order_system.Order.entity.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private double amount;

    private String status;

    private String paymentMethod;

    private LocalDateTime transactionTime;
}