package com.example.interviewdemoproject.Controllers;

import com.example.interviewdemoproject.Dtos.AccountDto;
import com.example.interviewdemoproject.Dtos.CustomerDto;
import com.example.interviewdemoproject.Dtos.TransactionDto;
import com.example.interviewdemoproject.Model.Account;
import com.example.interviewdemoproject.Model.Transaction;
import com.example.interviewdemoproject.Repository.AccountRepository;
import com.example.interviewdemoproject.Repository.TransactionRepository;
import com.example.interviewdemoproject.Services.BankService;
import com.example.interviewdemoproject.Services.CustomerService;
import com.example.interviewdemoproject.Services.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer-bank-details")
@CrossOrigin
public class BankController {

    private final BankService bankService;
    private final CustomerService customerService;
    private final TransactionService transactionService;

    @GetMapping("/customers/{customerId}/balance")
    @ResponseStatus(value = HttpStatus.OK)
    public BigDecimal getCustomerBalance(@PathVariable BigDecimal customerId) {
        return customerService.getCustomerBalance(customerId);
    }
    @GetMapping("/customers/{customerId}/mini-statement")
    public List<TransactionDto> getCustomerMiniStatement(@PathVariable BigDecimal customerId) {
        return customerService.getCustomerMiniStatement(customerId);
    }
    @PostMapping("/transactions/deposit")
    @CrossOrigin
    @ResponseStatus(value = HttpStatus.CREATED)
    public AccountDto cashDeposit(@RequestParam BigDecimal accountId, @RequestParam BigDecimal amount) {
        return bankService.cashDeposit(accountId, amount);
    }
    @PostMapping("/transactions/withdraw")
    @ResponseStatus(value = HttpStatus.CREATED)
    public AccountDto cashWithdrawal(@RequestParam BigDecimal accountId, @RequestParam BigDecimal amount) {
        return bankService.cashWithdrawal(accountId, amount);
    }

    @PostMapping("/transactions/transfer")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BigDecimal transferFunds(@RequestParam BigDecimal fromAccountId, @RequestParam BigDecimal toAccountId, @RequestParam BigDecimal amount) {
        return bankService.transferFunds(fromAccountId,toAccountId, amount);
    }
    @GetMapping("/transactions/{transactionId}")
    public List<TransactionDto> getTransactionDetails(@PathVariable BigDecimal transactionId) {
        return transactionService.getTransactionDetails(transactionId);
    }

}
