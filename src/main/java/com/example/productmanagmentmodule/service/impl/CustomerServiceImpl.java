package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.Customer;
import com.example.productmanagmentmodule.exception.CommonException;
import com.example.productmanagmentmodule.repository.CustomerRepository;
import com.example.productmanagmentmodule.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.productmanagmentmodule.util.JsonUtil.applyPaging;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Page<Customer> getAllCustomer(Integer page, Integer size) {
        List<Customer> customerList;
        customerList = customerRepository.findAll();
        return applyPaging(customerList, page, size);
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null){
            return customer;
        }
        throw new CommonException("400", "Customer doesn't exist");
    }

    @Override
    public String deleteCustomerById(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null){
            customerRepository.deleteById(customerId);
            return String.valueOf(customerId);
        }
        throw new CommonException("400", "Customer doesn't exist");
    }

    @Override
    public String createCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
        return String.valueOf(theCustomer.getCustomerId());
    }

    @Override
    public String updateCustomerById(Integer customerId, Customer theCustomer) {
        Customer updateCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CommonException("400", "Customer doesn't exist"));

        if (theCustomer.getCustomerName() != null) {
            updateCustomer.setCustomerName(theCustomer.getCustomerName());
        }
        if (theCustomer.getAddress() != null) {
            updateCustomer.setAddress(theCustomer.getAddress());
        }
        customerRepository.save(updateCustomer);
        return String.valueOf(customerId);
    }
}
