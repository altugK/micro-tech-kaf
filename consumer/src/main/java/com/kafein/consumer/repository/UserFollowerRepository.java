package com.kafein.consumer.repository;

import com.kafein.consumer.model.UserFollower;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFollowerRepository extends CassandraRepository<UserFollower, Integer> {
}
