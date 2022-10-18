package com.kafein.producer.controller;

import com.kafein.producer.dto.UserDto;
import com.kafein.producer.mapper.UserMapper;
import com.kafein.producer.model.User;
import com.kafein.producer.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserDto findById(@PathVariable UUID userId) {
        return UserMapper.tableToDto(this.userService.findById(userId));
    }

    @GetMapping
    public List<UserDto> findAll() {
        List<User> users = this.userService.findAll();
        return users.stream().map(UserMapper::tableToDto).collect(Collectors.toList());
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto orderDto) {
        return UserMapper.tableToDto(this.userService.create(UserMapper.dtoToTable(orderDto)));
    }


}
