package com.algaworks.algadelivery.delivery.tracking.api.controller;

import com.algaworks.algadelivery.delivery.tracking.api.model.DeliveryInput;
import com.algaworks.algadelivery.delivery.tracking.domain.model.Delivery;
import com.algaworks.algadelivery.delivery.tracking.domain.service.DeliveryPreparationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryPreparationService deliveryPreparationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery draft(@RequestBody @Valid DeliveryInput input) {
        return deliveryPreparationService.draft(input);
    }

    @PutMapping("/{deliveryId}")
    public Delivery edit(@PathVariable UUID deliveryId,
            @RequestBody @Valid DeliveryInput input) {
        return deliveryPreparationService.edit(deliveryId, input);
    }

}
