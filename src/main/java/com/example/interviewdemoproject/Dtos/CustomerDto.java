package com.example.interviewdemoproject.Dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @Nullable
    private BigDecimal id;
    @JsonAlias({"customerName", "customer_name"})
    private String customerName;
}
