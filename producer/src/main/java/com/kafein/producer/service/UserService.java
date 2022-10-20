package com.kafein.producer.service;

import com.kafein.producer.dto.UserRequest;
import com.kafein.producer.dto.UserResponse;
import com.kafein.producer.errors.CustomException;
import com.kafein.producer.mapper.UserMapper;
import com.kafein.producer.model.User;
import com.kafein.producer.model.UserFollower;
import com.kafein.producer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * {@link User} business logic işlemleri için kullanılacaktır.
 *
 * @author altugKarakayalı
 */
@Service
@Slf4j
public class UserService {

    private static final String USER_TOPIC = "user";

    private final KafkaTemplate<String, User> kafkaTemplate;

    private final UserRepository userRepository;

    private final UserFollowerService userFollowerService;

    public UserService(KafkaTemplate<String, User> kafkaTemplate, UserRepository userRepository, UserFollowerService userFollowerService) {
        this.kafkaTemplate = kafkaTemplate;
        this.userRepository = userRepository;
        this.userFollowerService = userFollowerService;
    }

    public User create(User user) {
        if (user == null) throw new CustomException("User cannot be null", HttpStatus.BAD_REQUEST);
        send(this.userRepository.save(user));
        return user;
    }

    /**
     * {@link User}'ın Kafkaya gönderildiği method. Consumer service karşılar.
     */
    public User send(User user) {
        kafkaTemplate.send(USER_TOPIC, user.getId().toString(), user);
        return user;
    }

    public UserResponse findById(UUID userId) {
        var tempUser = this.userRepository.findById(userId).orElseThrow(
                () -> new CustomException("User not found", HttpStatus.NOT_FOUND));

        return UserMapper.tableToDto(tempUser, userFollowerService.findByUserId(userId));
    }

    /**
     * {@link UserResponse} class yaratabilmek için {@link UserFollower} tablosu merge edilir.
     */
    public List<UserResponse> findAll() {
        List<User> users = this.userRepository.findAll();
        List<UserFollower> userFollowers = this.userFollowerService.findAll();

        return users.stream().map(user -> UserMapper
                .tableToDto(user, userFollowers.stream()
                        .filter(userFollower -> userFollower.getUserId().equals(user.getId()))
                        .findFirst()
                        .orElse(new UserFollower()))).collect(Collectors.toList());
    }

    /**
     * Kullanıcı güncelleme methodu.
     */
    public UserResponse update(UUID userId, UserRequest userRequest) {
        var tempUser = this.userRepository.findById(userId).orElseThrow(
                () -> new CustomException("User not found", HttpStatus.NOT_FOUND));

        tempUser.setName(userRequest.getName());
        tempUser.setSurname(userRequest.getSurname());
        mergeUserFollowedListAndRequestFollowedList(tempUser, userRequest);

        send(this.userRepository.save(tempUser));

        return UserMapper.tableToDto(tempUser, userFollowerService.findByUserId(userId));
    }

    /**
     * Güncelleme için mevcut takip edilen ve istek listeleri birleştirilir.
     */
    public void mergeUserFollowedListAndRequestFollowedList(User tempUser, UserRequest userRequest) {
        if (!userRequest.isAnyoneFollowed()) return;

        Set<UUID> followedList = new HashSet<>(tempUser.isAnyoneFollowed() ?
                tempUser.getFollowedList() : new ArrayList<>());

        followedList.addAll(userRequest.getFollowedList());

        tempUser.setFollowedList(followedList);
    }
}
