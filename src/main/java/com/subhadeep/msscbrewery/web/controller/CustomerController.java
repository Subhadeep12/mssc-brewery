package com.subhadeep.msscbrewery.web.controller;

import com.subhadeep.msscbrewery.services.CustomerService;
import com.subhadeep.msscbrewery.web.model.BeerDTO;
import com.subhadeep.msscbrewery.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService)
    {
        this.customerService=customerService;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") UUID id)
    {
       return new ResponseEntity<>(customerService.getCustomerbyId(id), HttpStatus.OK);
    }

    @PostMapping  //add new customer
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        CustomerDTO savedCustomer= customerService.saveCustomer(customerDTO);
        HttpHeaders httpHeaders =new HttpHeaders();
        httpHeaders.add("location","/api/v1/customer/" + savedCustomer.getCustomerId().toString());
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity(httpHeaders,HttpStatus.ACCEPTED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity updateCustomer(UUID customerId,@RequestBody  CustomerDTO customerDTO)
    {
        CustomerDTO updatedCustomer= customerService.updateCustomer(customerId,customerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId)
    {
         customerService.deleteCustomer(customerId);
    }
}
