package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.UserIdentity;
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
    public Page<UserIdentity> getAllCustomer(Integer page, Integer size) {
        List<UserIdentity> userIdentityList;
        userIdentityList = customerRepository.findAll();
        return applyPaging(userIdentityList, page, size);
    }

    @Override
    public UserIdentity getCustomerById(Integer customerId) {
        UserIdentity userIdentity = customerRepository.findById(customerId).orElse(null);
        if (userIdentity != null){
            return userIdentity;
        }
        throw new CommonException("400", "Customer doesn't exist");
    }

    @Override
    public String deleteCustomerById(Integer customerId) {
        UserIdentity userIdentity = customerRepository.findById(customerId).orElse(null);
        if (userIdentity != null){
            customerRepository.deleteById(customerId);
            return String.valueOf(customerId);
        }
        throw new CommonException("400", "Customer doesn't exist");
    }

    @Override
    public String createCustomer(UserIdentity theUserIdentity) {
        customerRepository.save(theUserIdentity);
        return String.valueOf(theUserIdentity.getId());
    }

    @Override
    public String updateCustomerById(Integer customerId, UserIdentity theUserIdentity) {
        UserIdentity updateUserIdentity = customerRepository.findById(customerId)
                .orElseThrow(() -> new CommonException("400", "Customer doesn't exist"));

        if (theUserIdentity.getEmail() != null){
            updateUserIdentity.setEmail(theUserIdentity.getEmail());
        }
        if (theUserIdentity.getPassword() != null){
            updateUserIdentity.setPassword(theUserIdentity.getPassword());
        }
        if (theUserIdentity.getFirstName() != null) {
            updateUserIdentity.setFirstName(theUserIdentity.getFirstName());
        }
        customerRepository.save(updateUserIdentity);
        return String.valueOf(customerId);
    }
}
