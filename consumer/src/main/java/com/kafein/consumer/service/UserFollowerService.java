package com.kafein.consumer.service;

import com.kafein.consumer.model.User;
import com.kafein.consumer.model.UserFollower;
import com.kafein.consumer.repository.UserFollowerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.HashSet;

/**
 * {@link UserFollower} business logic işlemleri için kullanılacaktır.
 *
 * @author altugKarakayalı
 */
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

    /**
     * Takip edilenlen kullanıcıların takip edenden kayıt edildiği method. Kafka'dan gelen {@link User} ile işlem yapılır.
     */
    public void createOrUpdate(User user) {
        if (!user.isAnyoneFollowed()) {
            log.info("User is not following anyone. userId: {}", user.getId());
            return;
        }

        Set<UUID> followedList = new HashSet<>(user.getFollowedList());

        followedList.forEach(followedId -> {
            UserFollower userFollower = findByUserId(followedId)
                    .orElse(UserFollower.builder()
                            .userId(followedId)
                            .followerList(new HashSet<>())
                            .build());

            userFollower.getFollowerList().add(user.getId());

            this.userFollowerRepository.save(userFollower);

            log.info("User: " + followedId + " is followed by: " + user.getId());
        });

    }

}
