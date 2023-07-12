package com.example.interviewdemoproject.Repository;

import com.example.interviewdemoproject.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, BigDecimal> {

    Optional<Account> findByCustomer_Id(BigDecimal customerId);
}
