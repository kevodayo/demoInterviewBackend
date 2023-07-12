package com.example.interviewdemoproject.Dtos;

import com.example.interviewdemoproject.Model.Customer;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @Nullable
    private BigDecimal id;
    @JsonAlias({"customerId", "customer_id"})
    private BigDecimal customerId;
    private BigDecimal balance;
    private String accountName;
}
