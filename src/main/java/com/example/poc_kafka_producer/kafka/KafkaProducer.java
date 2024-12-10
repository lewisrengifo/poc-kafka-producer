package com.example.poc_kafka_producer.kafka;

import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class KafkaProducer {
  private final ReactiveKafkaProducerTemplate<String, String> producerTemplate;

  @Scheduled(cron = "${application.cron.expression}")
  void sendMessage() {
    producerTemplate
        .send("bcp-poc-topic", UUID.randomUUID().toString(), UUID.randomUUID().toString())
        .doOnSuccess(
            senderResult -> {
              log.info("Message sent: {}", senderResult);
            })
        .doOnError(
            throwable -> {
              log.error("Error sending message: {}", throwable);
            })
        .subscribe();
  }
}
