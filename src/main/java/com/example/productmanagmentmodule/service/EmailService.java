package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.model.dto.EmailDetails;
import com.example.productmanagmentmodule.model.dto.ShippingDTO;

public interface EmailService {
    String sendSimpleMail(EmailDetails detail);

    String sendSimpleMail(ShippingDTO shippingDTO);

    String sendMailWithAttachment(EmailDetails details);
}
