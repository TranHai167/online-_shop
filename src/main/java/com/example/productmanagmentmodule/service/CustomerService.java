package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.entity.UserIdentity;
import org.springframework.data.domain.Page;

public interface CustomerService {
    public Page<UserIdentity> getAllCustomer(
            Integer page,
            Integer size
    );

    public UserIdentity getCustomerById(Integer customerId);

    public String deleteCustomerById(Integer customerId);

    public String createCustomer(UserIdentity theUserIdentity);

    public String updateCustomerById(Integer customerId, UserIdentity theUserIdentity);
}
