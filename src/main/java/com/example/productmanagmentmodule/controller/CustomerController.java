package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.entity.Customer;
import com.example.productmanagmentmodule.service.CustomerService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("Get all customer shopping in our online shop")
    public ResponseEntity<Page<Customer>> getAllCustomer(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        return ResponseEntity.ok(customerService.getAllCustomer(page, size));
    }

    @GetMapping("/getById")
    @ApiOperation("Get customer by specified ID")
    public ResponseEntity<Customer> getCustomerById(@RequestParam Integer customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @DeleteMapping("/delete")
    @ApiOperation("Delete customer by specified ID")
    public ResponseEntity<String> deleteCustomerById(@RequestParam Integer customerId){
        return ResponseEntity.ok(customerService.deleteCustomerById(customerId));
    }

    @PostMapping("/create")
    @ApiOperation("Create new customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping("/update")
    @ApiOperation("Update properties of customer by specified ID")
    public ResponseEntity<String> updateCustomer(
            @RequestParam Integer customerId,
            @RequestBody Customer customer
    ){
        return ResponseEntity.ok(customerService.updateCustomerById(customerId, customer));
    }
}
