package com.distributed_order_system.distributed_order_system.User.service;

import com.distributed_order_system.distributed_order_system.User.dto.UserCreateRequest;
import com.distributed_order_system.distributed_order_system.User.dto.UserResponse;
import com.distributed_order_system.distributed_order_system.User.dto.UserUpdateRequest;
import com.distributed_order_system.distributed_order_system.User.entity.User;
import com.distributed_order_system.distributed_order_system.User.mapper.UserMapper;
import com.distributed_order_system.distributed_order_system.User.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {
        User user = userMapper.userCreateRequestToUser(userCreateRequest);
        user.setRole("USER");
        return userMapper.userToUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse update(Long id, UserUpdateRequest userUpdateRequest) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        existing.setName(userUpdateRequest.getName());
        existing.setPassword(userUpdateRequest.getPassword());
        return userMapper.userToUserResponse(userRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse getById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::userToUserResponse)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserResponse)
                .toList();
    }
}
