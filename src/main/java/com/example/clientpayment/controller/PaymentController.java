package com.example.clientpayment.controller;


import com.example.clientpayment.model.PaymentRequest;
import com.example.clientpayment.model.PaymentResponse;
import com.example.clientpayment.model.paymentTypeEnum;
import com.example.clientpayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    Environment env;


    @GetMapping("/check")
    public String check(){
        return "client-payment is working at " + env.getProperty("local.server.port") + " port";
    }



    @PostMapping
    public PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.createPayment(paymentRequest);
    }

    @PutMapping
    public PaymentResponse updatePayment(@RequestParam String paymentId, @RequestBody PaymentRequest paymentRequest) {
        paymentRequest.setPaymentId(paymentRequest.getPaymentId());
        return paymentService.updatePayment(paymentId,paymentRequest);
    }

    @GetMapping("/client")
    public Page<PaymentResponse> getAllPaymentsByClientId(@RequestParam String clientId, Pageable pageable) {
        return paymentService.getAllPaymentsByClientId(clientId,pageable);
    }

    @GetMapping("/date")
    public Page<PaymentResponse> getAllPaymentsByDate(@RequestParam Date paymentDate, Pageable pageable){
        return paymentService.getAllPaymentsByDate(paymentDate,pageable);
    }

    @GetMapping("/type")
    public Page<PaymentResponse> getAllPaymentsByType(paymentTypeEnum paymentType, Pageable pageable){
        return paymentService.getAllPaymentsByType(paymentType,pageable);
    }

    @GetMapping
    public PaymentResponse getPaymentById(@RequestParam String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @GetMapping("/all")
    public List<PaymentResponse> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @DeleteMapping
    public void deletePaymentById(@RequestParam String paymentId) {
        paymentService.deletePaymentById(paymentId);
    }
}
