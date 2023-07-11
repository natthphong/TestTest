package com.auth2.azuread.controller.rest.batch;

import ch.qos.logback.core.joran.spi.DefaultClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String lastName;
    private String firstName;

}
