package com.kafein.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;
/**
 * Api Cevap classı.
 *  @author altugKarakayalı
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private UUID id;
    private String name;
    private String surname;
    private ArrayList<UUID> followedList;
    private ArrayList<UUID> followerList;

}
