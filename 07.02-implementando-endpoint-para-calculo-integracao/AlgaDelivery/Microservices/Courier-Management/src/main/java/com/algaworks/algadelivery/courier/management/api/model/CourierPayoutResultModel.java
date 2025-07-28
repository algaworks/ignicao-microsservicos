package com.algaworks.algadelivery.courier.management.api.model;

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
