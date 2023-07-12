package com.example.interviewdemoproject.Services;

import com.example.interviewdemoproject.Dtos.AccountDto;
import com.example.interviewdemoproject.Mappers.AccountMapper;
import com.example.interviewdemoproject.Model.Account;
import com.example.interviewdemoproject.Model.Customer;
import com.example.interviewdemoproject.Repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService{
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = accountMapper.mapToEntity(accountDto);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.mapToDTO(savedAccount);
    }
}
