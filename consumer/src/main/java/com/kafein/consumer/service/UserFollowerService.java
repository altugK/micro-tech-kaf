package com.kafein.consumer.service;

import com.kafein.consumer.errors.CustomException;
import com.kafein.consumer.model.User;
import com.kafein.consumer.model.UserFollower;
import com.kafein.consumer.repository.UserFollowerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserFollowerService {

    private final UserFollowerRepository userFollowerRepository;

    public UserFollowerService(UserFollowerRepository userFollowerRepository) {
        this.userFollowerRepository = userFollowerRepository;
    }

    public UserFollower findById(UUID userFollowerId) {
        return this.userFollowerRepository.findById(userFollowerId).orElseThrow(
                () -> new CustomException("UserFollower not found", HttpStatus.NOT_FOUND));
    }

    public List<UserFollower> findAll() {
        return this.userFollowerRepository.findAll();
    }

    public void createOrUpdate(String user) {
        //TODO: Implement this method
        log.info("UserFollower should be updated with new user followers: {}", user);
    }

}
