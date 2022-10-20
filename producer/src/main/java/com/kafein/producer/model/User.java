package com.kafein.producer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * Producer servisin sorumlu olduğu tablo.Takip edilenlerin listesini tutar.
 *
 * @author altugKarakayalı
 */
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

    private Set<UUID> followedList;

    private LocalDateTime createdDate;

    public boolean isAnyoneFollowed() {
        return this.followedList != null && !this.followedList.isEmpty();
    }
}
