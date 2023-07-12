package com.example.interviewdemoproject.Services;

import com.example.interviewdemoproject.Dtos.CustomerDto;
import com.example.interviewdemoproject.Dtos.TransactionDto;
import com.example.interviewdemoproject.Mappers.CustomerMapper;
import com.example.interviewdemoproject.Mappers.TransactionMapper;
import com.example.interviewdemoproject.Model.Account;
import com.example.interviewdemoproject.Model.Customer;
import com.example.interviewdemoproject.Model.Transaction;
import com.example.interviewdemoproject.Repository.AccountRepository;
import com.example.interviewdemoproject.Repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService{
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final CustomerMapper customerMapper;
    private final TransactionMapper transactionMapper;
    @Override
    public List<CustomerDto> getAListOfCustomers(Pageable pageable) {
        List<CustomerDto> response = new ArrayList<>();
        customerRepository.findAll(pageable).getContent().forEach(product -> response.add(customerMapper.mapToDTO(product)));
        return response;
    }

    @Override
    public BigDecimal getCustomerBalance(BigDecimal customerId) {
        Account account = accountRepository.findByCustomer_Id(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found for customer ID: " + customerId));

        return account.getBalance();
    }

    @Override
    public List<TransactionDto> getCustomerMiniStatement(BigDecimal customerId) {

        Account account = accountRepository.findByCustomer_Id(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found for customer ID: " + customerId));

        List<Transaction> transactions =  account.getTransactions();
        List<TransactionDto> transactionDtos =  transactions.stream()
                .map(transaction -> transactionMapper.mapToDTO(transaction))
                .limit(10)
                .collect(Collectors.toList());
        return transactionDtos;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.mapToEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.mapToDTO(savedCustomer);
    }

}
