package com.kafein.consumer.events;

import com.kafein.consumer.model.User;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Deprecated
public class UserDeserializer extends JsonDeserializer<User> {
    public UserDeserializer() {
        super(User.class);
    }
}
