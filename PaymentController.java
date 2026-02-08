package com.example.GM.Publication.controller;


import com.example.GM.Publication.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Step 1: Create Order
    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestParam Double amount)
            throws Exception {

        String orderId = paymentService.createOrder(amount);

        return ResponseEntity.ok(orderId);
    }

    // Step 2: Verify Payment
    @PostMapping("/verify")
    public ResponseEntity<?> verifyPayment(
            @RequestParam String orderId,
            @RequestParam String paymentId) {

        paymentService.verifyPayment(orderId, paymentId);
        return ResponseEntity.ok("Payment Successful");
    }
}
