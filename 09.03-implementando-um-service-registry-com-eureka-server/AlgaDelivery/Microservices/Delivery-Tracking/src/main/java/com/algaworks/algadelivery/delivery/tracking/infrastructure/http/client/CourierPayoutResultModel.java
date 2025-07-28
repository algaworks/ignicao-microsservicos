package com.algaworks.algadelivery.delivery.tracking.infrastructure.http.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CourierPayoutResultModel {
    private BigDecimal payoutFee;
}
