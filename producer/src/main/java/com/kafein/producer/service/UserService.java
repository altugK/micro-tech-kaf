package com.kafein.producer.service;

import com.kafein.producer.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    public User findById(UUID orderId) {
        return null;
    }

    public List<User> findAll() {
        return null;
    }

    public User send(User dtoToTable) {
        return null;
    }
}
