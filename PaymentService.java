package com.example.GM.Publication.service;

import com.example.GM.Publication.entity.PaymentOrder;
import com.example.GM.Publication.entity.Payment;
import com.example.GM.Publication.repository.PaymentOrderRepository;
import com.example.GM.Publication.repository.PaymentRepository;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.razorpay.Order;

@Service
public class PaymentService {

    private final RazorpayClient razorpayClient;
    private final PaymentOrderRepository paymentOrderRepository;

    public PaymentService(RazorpayClient razorpayClient,
                          PaymentOrderRepository paymentOrderRepository) {
        this.razorpayClient = razorpayClient;
        this.paymentOrderRepository = paymentOrderRepository;
    }

    public String createOrder(Double amount) throws Exception {

        JSONObject options = new JSONObject();
        options.put("amount", amount * 100); // paisa
        options.put("currency", "INR");
        options.put("receipt", "txn_" + System.currentTimeMillis());

        // ✅ Razorpay Order
        com.razorpay.Order razorpayOrder =
                razorpayClient.orders.create(options);

        // ✅ Your Entity
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setRazorpayOrderId(razorpayOrder.get("id"));
        paymentOrder.setAmount(amount);
        paymentOrder.setStatus("CREATED");

        paymentOrderRepository.save(paymentOrder);

        return razorpayOrder.get("id");
    }

    public void verifyPayment(String razorpayOrderId, String paymentId) {

        PaymentOrder paymentOrder = paymentOrderRepository
                .findByRazorpayOrderId(razorpayOrderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        paymentOrder.setPaymentId(paymentId);
        paymentOrder.setStatus("SUCCESS");

        paymentOrderRepository.save(paymentOrder);
    }
}
