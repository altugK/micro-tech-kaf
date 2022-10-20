package com.kafein.consumer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
/**
 *  Producer servisin sorumlu olduğu tablo deseni Pojo olarak tutuluyor.
 * @author altugKarakayalı
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User implements Serializable {

    private UUID id;

    private String name;

    private String surname;

    private Set<UUID> followedList;

    private LocalDateTime createdDate;

    public boolean isAnyoneFollowed() {
        return this.followedList != null && !this.followedList.isEmpty();
    }
}
