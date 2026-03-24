package com.distributed_order_system.distributed_order_system.Notification.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.Notification.entity.Notification;
import com.distributed_order_system.distributed_order_system.Notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification update(Long id, Notification notification) {
        Notification existing = notificationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Notification not found"));
        existing.setMessage(notification.getMessage());
        existing.setType(notification.getType());
        existing.setStatus(notification.getStatus());
        existing.setSentAt(notification.getSentAt());
        return notificationRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public Notification getById(Long id) {
        return notificationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Notification not found"));
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }
}
