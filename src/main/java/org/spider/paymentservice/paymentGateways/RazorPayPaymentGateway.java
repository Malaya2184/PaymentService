package org.spider.paymentservice.paymentGateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RazorPayPaymentGateway implements PaymentGateway{

    private RazorpayClient razorpay;
    public RazorPayPaymentGateway(RazorpayClient razorpay){
        this.razorpay = razorpay;
    }
    @Override
    public String createPaymentLink(Long orderId) throws RazorpayException {

//        config class created and razorpay client autowired
//        RazorpayClient razorpay = new RazorpayClient("[YOUR_KEY_ID]", "[YOUR_KEY_SECRET]");
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000); // == 10.00
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis()+900000); // expire after 15mins
        paymentLinkRequest.put("reference_id","MSPIDER1234"); // you can pass your order id here
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name","+919658218462");
        customer.put("contact","Malaya Kumar");
        customer.put("email","malayakumarswain8@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://github.com/Malaya2184/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
