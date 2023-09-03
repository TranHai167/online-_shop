package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.Customer;
import com.example.productmanagmentmodule.exception.CommonException;
import com.example.productmanagmentmodule.repository.CustomerRepository;
import com.example.productmanagmentmodule.service.CustomerService;
import com.twilio.rest.api.v2010.account.Message;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;

import java.util.List;
import java.util.Random;

import static com.example.productmanagmentmodule.util.JsonUtil.applyPaging;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public final String ACCOUNT_SID = "AC733a7d5293a443346589688a8fbae045";
    public final String AUTH_TOKEN = "882f75e50a08510e9a41a90c0a4f7b96";

    private String otpSent;

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
    public String generateOtp(Customer theCustomer) {
        Random random = new Random();

        int[] numbers = new int[6];
        StringBuffer otpSent = new StringBuffer();

        for (int i = 0; i < 6; i++) {
            int randomNumber = random.nextInt(10);
            numbers[i] = randomNumber;
            otpSent.append(numbers[i]);
        }
        this.otpSent = String.valueOf(otpSent);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+84928109167"),// thay đổi số ở chỗ này này
                        new com.twilio.type.PhoneNumber("+12542805668"),
                        String.valueOf(otpSent))
                .create();
        return String.valueOf(theCustomer.getCustomerId());
    }

    @Override
    public String VerifyOTP(String otpCheck) {
        if (otpCheck.equals(this.otpSent)) {
            return "Approved";
        }
        return "Declined";
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
