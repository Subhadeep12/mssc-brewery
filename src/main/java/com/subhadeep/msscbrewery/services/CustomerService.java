package com.subhadeep.msscbrewery.services;

import com.subhadeep.msscbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerbyId(UUID id);

    CustomerDTO saveCustomer(CustomerDTO customerDTO);


    CustomerDTO updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteCustomer(UUID customerId);
}
