package com.example.interviewdemoproject.Controllers;

import com.example.interviewdemoproject.Dtos.AccountDto;
import com.example.interviewdemoproject.Dtos.CustomerDto;
import com.example.interviewdemoproject.Services.AccountService;
import com.example.interviewdemoproject.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
@CrossOrigin
public class AccountController {
    private final AccountService accountService;
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        return accountService.createAccount(accountDto);
    }
}
