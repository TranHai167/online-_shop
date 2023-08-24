package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.entity.UserIdentity;
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
    public ResponseEntity<Page<UserIdentity>> getAllCustomer(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        return ResponseEntity.ok(customerService.getAllCustomer(page, size));
    }

    @GetMapping("/getById")
    @ApiOperation("Get customer by specified ID")
    public ResponseEntity<UserIdentity> getCustomerById(@RequestParam Integer customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @DeleteMapping("/delete")
    @ApiOperation("Delete customer by specified ID")
    public ResponseEntity<String> deleteCustomerById(@RequestParam Integer customerId){
        return ResponseEntity.ok(customerService.deleteCustomerById(customerId));
    }

    @PostMapping("/create")
    @ApiOperation("Create new customer")
    public ResponseEntity<String> createCustomer(@RequestBody UserIdentity userIdentity){
        return ResponseEntity.ok(customerService.createCustomer(userIdentity));
    }

    @PutMapping("/update")
    @ApiOperation("Update properties of customer by specified ID")
    public ResponseEntity<String> updateCustomer(
            @RequestParam Integer customerId,
            @RequestBody UserIdentity userIdentity
    ){
        return ResponseEntity.ok(customerService.updateCustomerById(customerId, userIdentity));
    }
}
