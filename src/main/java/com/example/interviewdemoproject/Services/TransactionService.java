package com.example.interviewdemoproject.Services;

import com.example.interviewdemoproject.Dtos.TransactionDto;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    List<TransactionDto> getTransactionDetails(BigDecimal transactionId);
}
