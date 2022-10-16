package com.kafein.consumer.mapper;

import com.kafein.consumer.dto.UserFollowerDto;
import com.kafein.consumer.model.UserFollower;
import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class UserFollowerMapper {

    public static UserFollower dtoToTable(UserFollowerDto userDto) {
        if (Objects.isNull(userDto)) return new UserFollower();
        return UserFollower.builder()
                .userId(userDto.getUserId())
                .followers(userDto.getFollowers())
                .build();
    }

    public UserFollowerDto tableToDto(UserFollower user) {
        if (Objects.isNull(user)) return new UserFollowerDto();
        return UserFollowerDto.builder()
                .userId(user.getUserId())
                .followers(user.getFollowers())
                .build();
    }
}
