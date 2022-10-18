package com.kafein.consumer.repository;

import com.kafein.consumer.model.UserFollower;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserFollowerRepository extends CassandraRepository<UserFollower, UUID> {
}
