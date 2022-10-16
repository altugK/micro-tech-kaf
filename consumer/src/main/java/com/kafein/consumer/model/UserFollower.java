package com.kafein.consumer.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table
public class UserFollower {

    @PrimaryKey
    private Integer id;

    private Integer userId;

    private HashSet<Integer> followers;

}
