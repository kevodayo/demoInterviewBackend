package com.example.interviewdemoproject.Services;

import com.example.interviewdemoproject.Dtos.AccountDto;
import com.example.interviewdemoproject.Mappers.AccountMapper;
import com.example.interviewdemoproject.Model.Account;
import com.example.interviewdemoproject.Model.Transaction;
import com.example.interviewdemoproject.Repository.AccountRepository;
import com.example.interviewdemoproject.Repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankServiceImp implements BankService{

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    @Override
    public AccountDto cashDeposit(BigDecimal accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with ID: " + accountId));

        BigDecimal currentBalance = account.getBalance();
        BigDecimal updatedBalance = currentBalance.add(amount);

        account.setBalance(updatedBalance);
        Account updatedAccount = accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(updatedAccount);
        transaction.setAmount(amount);
        transactionRepository.save(transaction);

        return accountMapper.mapToDTO(updatedAccount);
    }

    @Override
    public AccountDto cashWithdrawal(BigDecimal accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with ID: " + accountId));

        BigDecimal currentBalance = account.getBalance();
        BigDecimal updatedBalance = currentBalance.subtract(amount);

        if (updatedBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Insufficient funds in the account");
        }

        account.setBalance(updatedBalance);
        Account updatedAccount = accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(updatedAccount);
        transaction.setAmount(amount.negate()); // Use negative amount to indicate a withdrawal
        transactionRepository.save(transaction);
        return accountMapper.mapToDTO(updatedAccount);
    }

    @Override
    public BigDecimal transferFunds(BigDecimal fromAccountId, BigDecimal toAccountId, BigDecimal amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with ID: " + fromAccountId));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with ID: " + toAccountId));

        BigDecimal fromAccountBalance = fromAccount.getBalance();
        BigDecimal toAccountBalance = toAccount.getBalance();

        if (fromAccountBalance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds in the account");
        }

        BigDecimal updatedFromAccountBalance = fromAccountBalance.subtract(amount);
        BigDecimal updatedToAccountBalance = toAccountBalance.add(amount);

        fromAccount.setBalance(updatedFromAccountBalance);
        toAccount.setBalance(updatedToAccountBalance);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction debitTransaction = new Transaction();
        debitTransaction.setAccount(fromAccount);
        debitTransaction.setAmount(amount.negate()); // Use negative amount to indicate a withdrawal
        transactionRepository.save(debitTransaction);

        Transaction creditTransaction = new Transaction();
        creditTransaction.setAccount(toAccount);
        creditTransaction.setAmount(amount);
        transactionRepository.save(creditTransaction);

        return updatedFromAccountBalance;
    }
}
