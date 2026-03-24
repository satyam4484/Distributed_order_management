package com.distributed_order_system.distributed_order_system.Notification.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Notification.entity.Notification;

public interface NotificationService {
    Notification create(Notification notification);
    Notification update(Long id, Notification notification);
    void delete(Long id);
    Notification getById(Long id);
    List<Notification> getAll();
    List<Notification> getByUserId(Long userId);
}
