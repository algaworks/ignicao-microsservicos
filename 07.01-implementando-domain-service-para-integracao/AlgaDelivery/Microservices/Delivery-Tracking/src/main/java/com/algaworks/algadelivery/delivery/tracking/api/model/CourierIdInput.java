package com.algaworks.algadelivery.delivery.tracking.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CourierIdInput {
    private UUID courierId;
}
