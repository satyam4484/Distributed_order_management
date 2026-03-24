package com.distributed_order_system.distributed_order_system.User.service;

import com.distributed_order_system.distributed_order_system.User.dto.UserCreateRequest;
import com.distributed_order_system.distributed_order_system.User.dto.UserResponse;
import com.distributed_order_system.distributed_order_system.User.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {
    UserResponse create(UserCreateRequest userCreateRequest);
    UserResponse update(Long id, UserUpdateRequest userUpdateRequest);
    void delete(Long id);
    UserResponse getById(Long id);
    List<UserResponse> getAll();
}
