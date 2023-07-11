package com.auth2.azuread.controller.rest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QrModel {

    @NotNull
    @NotBlank
    private   String phone;

    @NotNull
    @NotBlank
    private String amount;
}
