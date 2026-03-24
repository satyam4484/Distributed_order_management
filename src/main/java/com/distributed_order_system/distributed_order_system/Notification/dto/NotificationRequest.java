package com.distributed_order_system.distributed_order_system.Notification.dto;

import lombok.Data;

@Data
public class NotificationRequest {
    private Long userId;
    private String message;
    private String type;
}
