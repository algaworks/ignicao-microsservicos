package com.algaworks.algadelivery.delivery.tracking.infrastructure.resilence4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import io.github.resilience4j.retry.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Resilence4jCircuitBreakerEventConsumer implements RegistryEventConsumer<CircuitBreaker> {

    @Override
    public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
        entryAddedEvent.getAddedEntry().getEventPublisher()
                .onEvent(event -> log.info(event.toString()));
    }

    @Override
    public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {

    }

    @Override
    public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {

    }
}
