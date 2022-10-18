package com.kafein.producer.service;

import com.kafein.producer.errors.CustomException;
import com.kafein.producer.model.User;
import com.kafein.producer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    private static final String USER_TOPIC = "user";

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final UserRepository userRepository;

    public UserService(KafkaTemplate<String, String> kafkaTemplate, UserRepository userRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.userRepository = userRepository;
    }

    public User findById(UUID userId) {
        return this.userRepository.findById(userId).orElseThrow(
                () -> new CustomException("User not found", HttpStatus.NOT_FOUND));
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User create(User user) {
        send(this.userRepository.save(user));
        return user;
    }

    public User send(User user) {
        kafkaTemplate.send(USER_TOPIC, user.getId().toString(), user.toString());
        return user;
    }

}
