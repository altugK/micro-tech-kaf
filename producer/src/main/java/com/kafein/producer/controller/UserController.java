package com.kafein.producer.controller;

import com.kafein.producer.dto.UserRequest;
import com.kafein.producer.dto.UserResponse;
import com.kafein.producer.mapper.UserMapper;
import com.kafein.producer.model.UserFollower;
import com.kafein.producer.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserResponse findById(@PathVariable UUID userId) {
        return this.userService.findById(userId);
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return this.userService.findAll();
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return UserMapper.tableToDto
                (this.userService.create
                        (UserMapper.dtoToTable(userRequest)), new UserFollower());
    }

    @PutMapping("/{userId}")
    public UserResponse update(@PathVariable UUID userId, @RequestBody UserRequest userRequest) {
        return this.userService.update(userId, userRequest);
    }

}
