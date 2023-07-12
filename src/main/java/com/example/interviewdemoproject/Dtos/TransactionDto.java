package com.example.interviewdemoproject.Dtos;

import com.example.interviewdemoproject.Model.Account;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    @Nullable
    private BigDecimal id;
    @JsonAlias({"accountCode", "account_code"})
    private BigDecimal accountCode;
    private BigDecimal amount;
    private BigDecimal transaction;
}
