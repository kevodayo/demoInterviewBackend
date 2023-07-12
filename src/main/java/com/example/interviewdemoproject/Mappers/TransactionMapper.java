package com.example.interviewdemoproject.Mappers;

import com.example.interviewdemoproject.Dtos.AccountDto;
import com.example.interviewdemoproject.Dtos.TransactionDto;
import com.example.interviewdemoproject.Model.Account;
import com.example.interviewdemoproject.Model.Transaction;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@RequiredArgsConstructor
public class TransactionMapper {
    private final ModelMapper mapper;
    public TransactionDto mapToDTO(Transaction transaction) {
        TransactionDto transactionDto = mapper.map(transaction, TransactionDto.class);
        return transactionDto;
    }
    public TransactionDto mapToDTO2(Transaction transaction) {
        TransactionDto transactionDto = mapper.map(transaction, TransactionDto.class);
        return transactionDto;
    }
    public Transaction mapToEntity(TransactionDto transactionDto) {
        Transaction transaction = mapper.map(transactionDto, Transaction.class);
        return transaction;
    }
}
