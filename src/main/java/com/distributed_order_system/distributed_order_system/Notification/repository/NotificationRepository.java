package com.distributed_order_system.distributed_order_system.Notification.repository;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId);
}
