package com.example.interviewdemoproject.Repository;

import com.example.interviewdemoproject.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface TransactionRepository extends JpaRepository<Transaction, BigDecimal> {
}
