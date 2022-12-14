package com.kafein.consumer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
/**
 *  Consumur servisin sorumlu olduğu tablodur. Kullanıcıların takipçilerini tutar.
 * @author altugKarakayalı
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table
public class UserFollower implements Serializable {

    @PrimaryKey
    private UUID userId;

    private Set<UUID> followerList;

}
