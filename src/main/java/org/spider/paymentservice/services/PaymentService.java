package org.spider.paymentservice.services;

import com.razorpay.RazorpayException;
import org.spider.paymentservice.paymentGateways.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;
    PaymentService (PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }


    public String createPaymetLink(Long orderId) throws RazorpayException {
//      call raorpay, stripe to generate paymet link
        return paymentGateway.createPaymentLink(orderId);
    }
}
