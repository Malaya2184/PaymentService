package org.spider.paymentservice.paymentGateways;

import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String createPaymentLink(Long orderId) {
        return "";
    }
}
