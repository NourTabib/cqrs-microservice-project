package com.nourtabib.app.queryservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listner {

    @KafkaListener(
            topics = "users.json",groupId = "query-service"
    )

    void listener(String data){
        System.out.println("Readed Event : " + data);
    }
}
