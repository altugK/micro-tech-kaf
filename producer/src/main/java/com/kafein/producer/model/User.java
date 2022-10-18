package com.kafein.producer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table
public class User implements Serializable {

    @PrimaryKey
    private UUID id;

    private String name;

    private String surname;

    private ArrayList<UUID> followerList;

    private LocalDateTime createdAt;

}
