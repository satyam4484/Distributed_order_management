package com.distributed_order_system.distributed_order_system.User.mapper;

import com.distributed_order_system.distributed_order_system.User.dto.UserCreateRequest;
import com.distributed_order_system.distributed_order_system.User.dto.UserResponse;
import com.distributed_order_system.distributed_order_system.User.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse userToUserResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    User userCreateRequestToUser(UserCreateRequest userCreateRequest);
}
