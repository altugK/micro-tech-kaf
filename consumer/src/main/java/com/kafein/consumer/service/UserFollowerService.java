package com.kafein.consumer.service;

import com.kafein.consumer.model.User;
import com.kafein.consumer.model.UserFollower;
import com.kafein.consumer.repository.UserFollowerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserFollowerService {

    private final UserFollowerRepository userFollowerRepository;

    public UserFollowerService(UserFollowerRepository userFollowerRepository) {
        this.userFollowerRepository = userFollowerRepository;
    }

    public Optional<UserFollower> findByUserId(UUID userId) {
        return this.userFollowerRepository.findByUserId(userId);
    }

    public void createOrUpdate(User user) {
        if (user.getFollowerList().isEmpty()) return;

        Set<UUID> followedList = new HashSet<>(user.getFollowerList());

        followedList.forEach(followedId -> {
            UserFollower userFollower = findByUserId(followedId)
                    .orElse(UserFollower.builder()
                            .userId(followedId)
                            .followers(new ArrayList<>())
                            .build());

            userFollower.getFollowers().add(user.getId());

            this.userFollowerRepository.save(userFollower);

            log.info("User: " + followedId + " is followed by: " + user.getId());
        });


    }

}
