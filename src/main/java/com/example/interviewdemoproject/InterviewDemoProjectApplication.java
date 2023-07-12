package com.example.interviewdemoproject;

import com.example.interviewdemoproject.Mappers.AccountMapper;
import com.example.interviewdemoproject.Mappers.CustomerMapper;
import com.example.interviewdemoproject.Mappers.TransactionMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InterviewDemoProjectApplication {
    @Bean
    public CustomerMapper customerMapper(ModelMapper modelMapper) {
        return new CustomerMapper(modelMapper);
    }
    @Bean
    public TransactionMapper transactionMapper(ModelMapper modelMapper) {
        return new TransactionMapper(modelMapper);
    }
    @Bean
    public AccountMapper accountMapper(ModelMapper modelMapper) {
        return new AccountMapper(modelMapper);
    }
    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(InterviewDemoProjectApplication.class, args);
    }

}
