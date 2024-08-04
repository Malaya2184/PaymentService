package org.spider.paymentservice.paymentGateways;

import com.razorpay.RazorpayException;

//@Component
public interface PaymentGateway {

    String createPaymentLink(Long orderId) throws RazorpayException;
}
