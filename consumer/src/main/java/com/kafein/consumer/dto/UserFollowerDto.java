package com.kafein.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFollowerDto {

    private Integer userId;

    private HashSet<Integer> followers;

}
