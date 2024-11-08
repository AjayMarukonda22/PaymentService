package com.dev.paymentservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripeWebhook")
public class StripeWebhookController{
    @PostMapping
    public void initiatePayment() {
        System.out.println("The payment is initiated");
    }
}
