package com.example.interviewdemoproject.Services;

import com.example.interviewdemoproject.Dtos.TransactionDto;
import com.example.interviewdemoproject.Mappers.TransactionMapper;
import com.example.interviewdemoproject.Model.Transaction;
import com.example.interviewdemoproject.Repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService{
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    @Override
    public List<TransactionDto> getTransactionDetails(BigDecimal transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with ID: " + transactionId));
        List<Transaction> items = new ArrayList<>();
        items.add(transaction);
        List<TransactionDto> transactionDtos = items.stream().distinct()
                .map(transaction1 -> transactionMapper.mapToDTO2(transaction1)).collect(Collectors.toList());
        return transactionDtos;
    }
}
