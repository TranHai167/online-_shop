package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.dto.ShippingDTO;
import com.example.productmanagmentmodule.model.EmailDetails;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

public interface EmailService {
    String sendSimpleMail(EmailDetails detail);

    String sendSimpleMail(ShippingDTO shippingDTO);

    String sendMailWithAttachment(EmailDetails details);
}
