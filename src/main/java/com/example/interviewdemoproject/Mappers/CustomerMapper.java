package com.example.interviewdemoproject.Mappers;

import com.example.interviewdemoproject.Dtos.CustomerDto;
import com.example.interviewdemoproject.Model.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
@RequiredArgsConstructor
public class CustomerMapper {
    private final ModelMapper mapper;
    public CustomerDto mapToDTO(Customer customer) {
        CustomerDto customerDto = mapper.map(customer, CustomerDto.class);
        return customerDto;
    }
    public Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = mapper.map(customerDto, Customer.class);
        return customer;
    }
}
