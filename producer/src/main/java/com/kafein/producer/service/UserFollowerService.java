package com.kafein.producer.service;

import com.kafein.producer.model.UserFollower;
import com.kafein.producer.repository.UserFollowerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
/**
 *  Takipçilerin {@link com.kafein.producer.dto.UserResponse} ile birlikte gitmesi için business logic işlemleri.
 * @author altugKarakayalı
 */
@Service
@Slf4j
public class UserFollowerService {

    private final UserFollowerRepository userFollowerRepository;

    public UserFollowerService(UserFollowerRepository userFollowerRepository) {
        this.userFollowerRepository = userFollowerRepository;
    }

    public UserFollower findByUserId(UUID userId) {
        return this.userFollowerRepository.findByUserId(userId).orElse(new UserFollower());
    }

    public List<UserFollower> findAll() {
        return this.userFollowerRepository.findAll();
    }

}
