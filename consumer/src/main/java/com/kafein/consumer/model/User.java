package com.kafein.consumer.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Deprecated
public class User implements Serializable {

    private UUID id;

    private String name;

    private String surname;

    private HashSet<Integer> followerList;

    private LocalDateTime createdAt;

}
