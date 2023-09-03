package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.entity.Customer;
import org.springframework.data.domain.Page;

public interface CustomerService {
    public Page<Customer> getAllCustomer(
            Integer page,
            Integer size
    );

    public Customer getCustomerById(Integer customerId);

    public String deleteCustomerById(Integer customerId);

    public String generateOtp(Customer theCustomer);

    public String VerifyOTP(String otp);

    public String updateCustomerById(Integer customerId, Customer theCustomer);
}
