package com.algaworks.algadelivery.delivery.tracking.infrastructure.kafka;

import com.algaworks.algadelivery.delivery.tracking.infrastructure.event.IntegrationEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class IntegrationEventPublisherKafkaImpl implements IntegrationEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void publish(Object event, String key, String topic) {
        SendResult<String, Object> result = kafkaTemplate.send(topic, key, event).join();
        RecordMetadata recordMetadata = result.getRecordMetadata();
        log.info("Message publish: \n\t Topic: {} \n\t Offset: {}", recordMetadata.topic(), recordMetadata.offset());
    }
}
