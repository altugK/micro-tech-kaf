package com.kafein.consumer.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.HashSet;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table
public class UserFollower implements Serializable {

    @PrimaryKey
    private UUID id;

    private UUID userId;

    private HashSet<UUID> followers;

}
