package com.netshoes.sample.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @RestController
  @RequiredArgsConstructor
  @Slf4j
  public static class Controller {
    private final Producer producer;

    @PostMapping(value = "/send", consumes = "text/plain")
    public void sendMessage(@RequestBody String message) {
      producer.send(message);
    }
  }
}
