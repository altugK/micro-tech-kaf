package com.kafein.consumer.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table
public class User {

    @PrimaryKey
    private Integer id;

    private String name;

    private String surname;

    private HashSet<Integer> followerList;

    private LocalDateTime createdAt;

}
