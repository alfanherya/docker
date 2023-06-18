package com.herya.tutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herya.tutorial.kafka.JsonKafkaProducer;
import com.herya.tutorial.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    private JsonKafkaProducer  jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message sent to kafka topic");
    }
}
