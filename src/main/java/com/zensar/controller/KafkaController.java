package com.zensar.controller;

import com.zensar.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
  private KafkaProducer producer;

    @GetMapping("/publish") //localhost:8080/api/kafka/publish?message=hello world
    public ResponseEntity<String>kafkaPublish (@RequestParam("message")String message){
        producer.send(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
