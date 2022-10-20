package com.kafein.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.UUID;

/**
 * User Kayıt Deseni istenen class.
 *  @author altugKarakayalı
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private String name;
    private String surname;
    private ArrayList<UUID> followedList;

    @Transient
    public boolean isAnyoneFollowed() {
        return this.followedList != null && !this.followedList.isEmpty();
    }

}
