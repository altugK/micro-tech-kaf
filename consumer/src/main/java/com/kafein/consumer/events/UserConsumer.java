package com.kafein.consumer.events;

import com.kafein.consumer.service.UserFollowerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserConsumer {
    private final UserFollowerService userFollowerService;

    public UserConsumer(UserFollowerService userFollowerService) {
        this.userFollowerService = userFollowerService;
    }

    @KafkaListener(topics = "user", groupId = "user-group")
    public void consumer(final ConsumerRecord<String, String> consumerRecord) {
        log.info("1 handle with followers: {}", consumerRecord.key());
        userFollowerService.createOrUpdate(consumerRecord.value());
    }

}
