package com.distributed_order_system.distributed_order_system.Notification.entity;

import java.time.LocalDateTime;

import com.distributed_order_system.distributed_order_system.User.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String message;

    private String type;

    private String status;

    private LocalDateTime sentAt;
}