package com.example.interviewdemoproject.Controllers;

import com.example.interviewdemoproject.Dtos.CustomerDto;
import com.example.interviewdemoproject.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAListOfCustomers(@RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo,
                                                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(customerService.getAListOfCustomers(PageRequest.of(pageNo, pageSize)), HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }
}
