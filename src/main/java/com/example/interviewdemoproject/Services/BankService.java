package com.example.interviewdemoproject.Services;

import com.example.interviewdemoproject.Dtos.AccountDto;

import java.math.BigDecimal;

public interface BankService {
    AccountDto cashDeposit(BigDecimal accountId, BigDecimal amount);

    AccountDto cashWithdrawal(BigDecimal accountId, BigDecimal amount);

    BigDecimal transferFunds(BigDecimal fromAccountId, BigDecimal toAccountId, BigDecimal amount);
}
