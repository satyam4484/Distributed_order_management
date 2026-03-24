package com.distributed_order_system.distributed_order_system.User.service;

import java.util.List;

import com.distributed_order_system.distributed_order_system.User.entity.User;

public interface UserService {
    User create(User user);
    User update(Long id, User user);
    void delete(Long id);
    User getById(Long id);
    List<User> getAll();
}
