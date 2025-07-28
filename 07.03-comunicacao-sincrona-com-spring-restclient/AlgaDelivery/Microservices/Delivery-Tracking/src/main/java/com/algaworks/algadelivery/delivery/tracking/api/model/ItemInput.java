package com.algaworks.algadelivery.delivery.tracking.api.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemInput {

    @NotBlank
    private String name;

    @NotNull
    @Min(1)
    private Integer quantity;
}
