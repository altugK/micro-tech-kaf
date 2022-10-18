package com.kafein.producer.mapper;

import com.kafein.producer.dto.UserDto;
import com.kafein.producer.model.User;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@UtilityClass
public class UserMapper {

    public static User dtoToTable(UserDto userDto) {
        if (Objects.isNull(userDto)) return new User();

        return User.builder()
                .id(UUID.randomUUID())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .followerList(userDto.getFollowerList())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public UserDto tableToDto(User user) {
        if (Objects.isNull(user)) return new UserDto();

        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .followerList(user.getFollowerList())
                .build();
    }
}
