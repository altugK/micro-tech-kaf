package com.kafein.producer.repository;

import com.kafein.producer.model.UserFollower;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserFollowerRepository extends CassandraRepository<UserFollower, UUID> {

    Optional<UserFollower> findByUserId(UUID userId);
}
