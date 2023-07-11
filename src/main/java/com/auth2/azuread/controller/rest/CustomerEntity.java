package com.auth2.azuread.controller.rest;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.io.Serializable;

@Entity
@Data
@Table(name = "CUSTOMER_INFO")
public class CustomerEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String email;
    private Integer age;
    private String password;
}
