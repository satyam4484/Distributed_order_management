package com.distributed_order_system.distributed_order_system.Notification.mapper;

import com.distributed_order_system.distributed_order_system.Notification.dto.NotificationResponse;
import com.distributed_order_system.distributed_order_system.Notification.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    @Mapping(source = "user.id", target = "userId")
    NotificationResponse toResponse(Notification notification);
}
