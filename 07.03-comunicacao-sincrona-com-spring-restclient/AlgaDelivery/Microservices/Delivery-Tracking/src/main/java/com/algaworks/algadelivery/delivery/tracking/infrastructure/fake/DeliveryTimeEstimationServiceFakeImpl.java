package com.algaworks.algadelivery.delivery.tracking.infrastructure.fake;

import com.algaworks.algadelivery.delivery.tracking.domain.model.ContactPoint;
import com.algaworks.algadelivery.delivery.tracking.domain.service.DeliveryEstimate;
import com.algaworks.algadelivery.delivery.tracking.domain.service.DeliveryTimeEstimationService;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class DeliveryTimeEstimationServiceFakeImpl
        implements DeliveryTimeEstimationService {
    @Override
    public DeliveryEstimate estimate(ContactPoint sender, ContactPoint receiver) {
        return new DeliveryEstimate(
                Duration.ofHours(3),
                3.1
        );
    }
}
