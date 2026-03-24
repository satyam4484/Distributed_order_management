package com.distributed_order_system.distributed_order_system.Notification.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NotificationResponse {
    private Long id;
    private Long userId;
    private String message;
    private String type;
    private String status;
    private LocalDateTime sentAt;
}
