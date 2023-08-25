package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.model.EmailDetails;
import com.example.productmanagmentmodule.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Sending a simple Email
    @PostMapping("/send")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        String status = emailService.sendSimpleMail(details);

        return status;
    }
}
