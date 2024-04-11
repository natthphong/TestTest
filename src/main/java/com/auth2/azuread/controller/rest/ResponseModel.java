package com.auth2.azuread.controller.rest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseModel <T>  implements Serializable {
    private String code;
    private String description;
    private T body;
}
