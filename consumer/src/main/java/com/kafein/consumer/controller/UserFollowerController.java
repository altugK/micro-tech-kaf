package com.kafein.consumer.controller;

import com.kafein.consumer.dto.UserFollowerDto;
import com.kafein.consumer.mapper.UserFollowerMapper;
import com.kafein.consumer.model.UserFollower;
import com.kafein.consumer.service.UserFollowerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/follower/v1")
public class UserFollowerController {

    private final UserFollowerService userService;

    public UserFollowerController(UserFollowerService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserFollowerDto findById(@PathVariable UUID orderId) {
        return UserFollowerMapper.tableToDto(this.userService.findById(orderId));
    }

    @GetMapping
    public List<UserFollowerDto> findAll() {
        List<UserFollower> users = this.userService.findAll();
        return users.stream().map(UserFollowerMapper::tableToDto).collect(Collectors.toList());
    }
}
