package com.example.interviewdemoproject.Services;

import com.example.interviewdemoproject.Dtos.CustomerDto;
import com.example.interviewdemoproject.Dtos.TransactionDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAListOfCustomers(Pageable pageable);

    BigDecimal getCustomerBalance(BigDecimal customerId);

    List<TransactionDto> getCustomerMiniStatement(BigDecimal customerId);

    CustomerDto createCustomer(CustomerDto customerDto);
}
