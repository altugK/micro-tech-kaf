package com.kafein.producer.mapper;

import com.kafein.producer.dto.UserDto;
import com.kafein.producer.model.User;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.Objects;

@UtilityClass
public class UserMapper {

    public static User dtoToTable(UserDto userDto) {
        if (Objects.isNull(userDto)) return new User();

        return User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public UserDto tableToDto(User user) {
        if (Objects.isNull(user)) return new UserDto();

        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }
}
