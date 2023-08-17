package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.entity.Customer;
import com.example.productmanagmentmodule.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/get")
    public ResponseEntity<Page<Customer>> getAllCustomer(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        return ResponseEntity.ok(customerService.getAllCustomer(page, size));
    }

    @GetMapping("/getById")
    public ResponseEntity<Customer> getCustomerById(@RequestParam Integer customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomerById(@RequestParam Integer customerId){
        return ResponseEntity.ok(customerService.deleteCustomerById(customerId));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(
            @RequestParam Integer customerId,
            @RequestBody Customer customer
    ){
        return ResponseEntity.ok(customerService.updateCustomerById(customerId, customer));
    }
}
