package com.subhadeep.msscbrewery.services;

import com.subhadeep.msscbrewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{
    @Override
    public CustomerDTO getCustomerbyId(UUID id)
    {
        return CustomerDTO.builder().customerId(UUID.randomUUID())
                .customerName("Subhadeep")
                .build();
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .customerId(UUID.randomUUID())
                .build();
    }

    @Override
    public CustomerDTO updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        //todo: implement it later
        return null;
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting customer ");
    }
}

