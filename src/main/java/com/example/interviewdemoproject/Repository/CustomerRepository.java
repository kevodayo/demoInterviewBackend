package com.example.interviewdemoproject.Repository;

import com.example.interviewdemoproject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CustomerRepository extends JpaRepository<Customer, BigDecimal> {
}
