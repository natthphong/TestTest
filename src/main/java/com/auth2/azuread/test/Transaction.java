package com.auth2.azuread.test;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "txn_type", nullable = false)
    private String txnType;
    @Column(name = "request_ref", nullable = false)
    private String requestRef;

    @Column(name = "current_price", nullable = false)
    private int currentPrice;
    @Column(name = "sale_id", nullable = false)
    private String saleId;




    @Column(name = "status", nullable = false, length = 20)
    private String status = "CF";

    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "create_by", length = 100)
    private String createBy;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();
    @Column(name = "confirm_date", nullable = false)
    private LocalDateTime confirmDate;
    // Constructors, getters, and setters (omitted for brevity)
    // Create constructors, getters, and setters for your fields
}
