package com.distributed_order_system.distributed_order_system.User.dto;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String name;
    private String password;
}
