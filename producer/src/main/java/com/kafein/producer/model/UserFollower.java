package com.kafein.producer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

/**
 * Consumerın sorumlu olduğu tablo. Response mapping için yaratıldı.
 *
 * @author altugKarakayalı
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table
public class UserFollower {

    @PrimaryKey
    private UUID userId;

    private Set<UUID> followerList;

    public boolean isAnyoneFollowed() {
        return this.followerList != null && !this.followerList.isEmpty();
    }


}
