package com.kafein.producer.mapper;

import com.kafein.producer.dto.UserRequest;
import com.kafein.producer.dto.UserResponse;
import com.kafein.producer.model.User;
import com.kafein.producer.model.UserFollower;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

/**
 * Dto classları için dönüşüm işlemlerinin yapılığı class.
 *
 * @author altugKarakayalı
 */
@UtilityClass
public class UserMapper {

    public static User dtoToTable(UserRequest userRequest) {
        if (Objects.isNull(userRequest)) return new User();

        return User.builder()
                .id(UUID.randomUUID())
                .name(userRequest.getName())
                .surname(userRequest.getSurname())
                .followedList(new HashSet<>(userRequest.isAnyoneFollowed() ? userRequest.getFollowedList() : new ArrayList<>()))
                .createdDate(LocalDateTime.now()).build();
    }

    public UserResponse tableToDto(User user, UserFollower userFollower) {
        if (Objects.isNull(user)) return new UserResponse();

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .followedList(new ArrayList<>(user.isAnyoneFollowed() ? user.getFollowedList() : new ArrayList<>()))
                .followerList(new ArrayList<>(userFollower.isAnyoneFollowed() ? userFollower.getFollowerList() : new ArrayList<>())).build();
    }
}
