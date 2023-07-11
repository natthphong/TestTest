package com.auth2.azuread.controller.rest;


import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseModel <T>  implements Serializable {
    private String code;
    private String description;
    private T body;
}
