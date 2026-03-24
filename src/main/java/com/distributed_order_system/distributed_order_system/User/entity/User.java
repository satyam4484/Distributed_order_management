package com.distributed_order_system.distributed_order_system.User.entity;

import java.util.ArrayList;
import java.util.List;

import com.distributed_order_system.distributed_order_system.Order.entity.Order;
import com.distributed_order_system.distributed_order_system.Notification.entity.Notification;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications = new ArrayList<>();
}