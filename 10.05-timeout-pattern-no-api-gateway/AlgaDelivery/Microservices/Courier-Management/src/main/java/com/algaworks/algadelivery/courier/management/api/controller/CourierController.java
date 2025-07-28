package com.algaworks.algadelivery.courier.management.api.controller;

import com.algaworks.algadelivery.courier.management.api.model.CourierInput;
import com.algaworks.algadelivery.courier.management.api.model.CourierPayoutCalculationInput;
import com.algaworks.algadelivery.courier.management.api.model.CourierPayoutResultModel;
import com.algaworks.algadelivery.courier.management.domain.model.Courier;
import com.algaworks.algadelivery.courier.management.domain.repository.CourierRepository;
import com.algaworks.algadelivery.courier.management.domain.service.CourierPayoutService;
import com.algaworks.algadelivery.courier.management.domain.service.CourierRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/couriers")
@RequiredArgsConstructor
@Slf4j
public class CourierController {

    private final CourierRegistrationService courierRegistrationService;
    private final CourierRepository courierRepository;

    private final CourierPayoutService courierPayoutService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Courier create(@Valid @RequestBody CourierInput input) {
        return courierRegistrationService.create(input);
    }

    @PutMapping("/{courierId}")
    public Courier update(@PathVariable UUID courierId,
                          @Valid @RequestBody CourierInput input) {
        return courierRegistrationService.update(courierId, input);
    }

    @GetMapping
    public PagedModel<Courier> findAll(@PageableDefault Pageable pageable) {
        log.info("FindAll Request");
        return new PagedModel<>(courierRepository.findAll(pageable));
    }

    @GetMapping("/{courierId}")
    public Courier findById(@PathVariable UUID courierId) {
        return courierRepository.findById(courierId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @SneakyThrows
    @PostMapping("/payout-calculation")
    public CourierPayoutResultModel calculate(
            @RequestBody CourierPayoutCalculationInput input) {
        log.info("Calculating");

        if (Math.random() < 0.5) {
            throw new RuntimeException();
        }

        int millis = new Random().nextInt(400);
        Thread.sleep(millis);

        BigDecimal payoutFee = courierPayoutService.calculate(input.getDistanceInKm());
        return new CourierPayoutResultModel(payoutFee);
    }

}
