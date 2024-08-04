package org.spider.paymentservice.configuration;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayCnfig {
    @Value("${razorpay.key.id}")
    private String razorPayKeyId;
    @Value("${razorpay.key.secret}")
    private String razorPaySecret;
    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorPayKeyId, razorPaySecret);
    }
}
