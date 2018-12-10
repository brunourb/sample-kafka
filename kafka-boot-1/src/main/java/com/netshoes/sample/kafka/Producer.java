package com.netshoes.sample.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {
  private final KafkaTemplate kafkaTemplate;

  public void send(String message) {
    kafkaTemplate
        .send("sample", message)
        .addCallback(
            new ListenableFutureCallback<SendResult>() {
              @Override
              public void onSuccess(SendResult result) {
                final ProducerRecord producerRecord = result.getProducerRecord();
                log.info(
                    "Message {} with key {} published in partition: {}",
                    producerRecord.value(),
                    producerRecord.key(),
                    result.getRecordMetadata().partition());
              }

              @Override
              public void onFailure(Throwable ex) {
                log.error(ex.getMessage(), ex);
              }
            });
  }
}
