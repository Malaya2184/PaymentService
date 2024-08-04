package org.spider.paymentservice.controllers;

import com.razorpay.RazorpayException;
import org.spider.paymentservice.dtos.CreatePaymentLinkRequestDto;
import org.spider.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/")
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDto requestDto) throws RazorpayException {
        return paymentService.createPaymetLink(requestDto.getOrderId());
    }
}
