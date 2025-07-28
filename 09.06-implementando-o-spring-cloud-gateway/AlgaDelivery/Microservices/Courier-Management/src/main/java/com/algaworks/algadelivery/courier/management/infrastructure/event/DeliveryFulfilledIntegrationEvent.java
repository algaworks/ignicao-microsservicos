package com.algaworks.algadelivery.courier.management.infrastructure.event;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class DeliveryFulfilledIntegrationEvent {
    private OffsetDateTime occurredAt;
    private UUID deliveryId;
}
