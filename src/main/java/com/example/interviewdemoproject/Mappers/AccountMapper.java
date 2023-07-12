package com.example.interviewdemoproject.Mappers;

import com.example.interviewdemoproject.Dtos.AccountDto;
import com.example.interviewdemoproject.Dtos.CustomerDto;
import com.example.interviewdemoproject.Model.Account;
import com.example.interviewdemoproject.Model.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
@RequiredArgsConstructor
public class AccountMapper {

    private final ModelMapper mapper;
    public AccountDto mapToDTO(Account account) {
        AccountDto accountDto = mapper.map(account, AccountDto.class);
        return accountDto;
    }
    public Account mapToEntity(AccountDto accountDto) {
        Account account = mapper.map(accountDto, Account.class);
        return account;
    }
}
