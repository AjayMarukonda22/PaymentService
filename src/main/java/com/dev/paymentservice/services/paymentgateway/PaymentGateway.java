package com.dev.paymentservice.services.paymentgateway;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    String generateLink() ;
}
