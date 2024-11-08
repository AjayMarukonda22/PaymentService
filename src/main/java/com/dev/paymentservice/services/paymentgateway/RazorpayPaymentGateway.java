package com.dev.paymentservice.services.paymentgateway;

import com.razorpay.PaymentLink;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentGateway{
    @Override
    public String generateLink() {
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_Pq7SxSV4cZHa7c", "u19ZEa1WLn4HQKcf3p6AFt7C");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", 1000);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", false);
            paymentLinkRequest.put("expire_by", 1749091200);
            paymentLinkRequest.put("reference_id", "AP1989");
            paymentLinkRequest.put("description", "Payment for policy no #23456");
            JSONObject customer = new JSONObject();
            customer.put("name", "Ajay");
            customer.put("contact", "+918465024350");
            customer.put("email", "ajayprabha2576@gmail.com");
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("reminder_enable", false);
            paymentLinkRequest.put("callback_url", "https://google.com");
            paymentLinkRequest.put("callback_method", "get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            return payment.toString();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
