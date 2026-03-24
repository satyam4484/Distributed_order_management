package com.distributed_order_system.distributed_order_system.Notification.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.distributed_order_system.distributed_order_system.Notification.dto.NotificationRequest;
import com.distributed_order_system.distributed_order_system.Notification.dto.NotificationResponse;
import com.distributed_order_system.distributed_order_system.Notification.entity.Notification;
import com.distributed_order_system.distributed_order_system.Notification.mapper.NotificationMapper;
import com.distributed_order_system.distributed_order_system.Notification.repository.NotificationRepository;
import com.distributed_order_system.distributed_order_system.User.entity.User;
import com.distributed_order_system.distributed_order_system.User.repository.UserRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final NotificationMapper mapper;

    @Override
    public NotificationResponse create(NotificationRequest notificationRequest) {
        User user = userRepository.findById(notificationRequest.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(notificationRequest.getMessage());
        notification.setType(notificationRequest.getType());
        notification.setStatus("SENT");
        notification.setSentAt(LocalDateTime.now());

        return mapper.toResponse(notificationRepository.save(notification));
    }

    @Override
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public NotificationResponse getById(Long id) {
        return notificationRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Notification not found"));
    }

    @Override
    public List<NotificationResponse> getAll() {
        return notificationRepository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationResponse> getByUserId(Long userId) {
        return notificationRepository.findByUserId(userId).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
