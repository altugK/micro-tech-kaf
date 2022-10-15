package com.kafein.producer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;

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

    private ArrayList<Integer> followerList;

    private LocalDateTime createdAt;

}
