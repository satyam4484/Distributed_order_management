package com.distributed_order_system.distributed_order_system.Notification.service;

import com.distributed_order_system.distributed_order_system.Notification.dto.NotificationRequest;
import com.distributed_order_system.distributed_order_system.Notification.dto.NotificationResponse;

import java.util.List;

public interface NotificationService {
    NotificationResponse create(NotificationRequest notificationRequest);
    void delete(Long id);
    NotificationResponse getById(Long id);
    List<NotificationResponse> getAll();
    List<NotificationResponse> getByUserId(Long userId);
}
