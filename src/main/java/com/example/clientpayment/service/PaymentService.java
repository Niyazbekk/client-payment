package com.example.clientpayment.service;

import com.example.clientpayment.model.PaymentRequest;
import com.example.clientpayment.model.PaymentResponse;
import com.example.clientpayment.model.paymentTypeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PaymentService {
    PaymentResponse createPayment(PaymentRequest paymentRequest);

    PaymentResponse updatePayment(String paymentId,PaymentRequest paymentRequest);

    Page<PaymentResponse> getAllPaymentsByClientId(String clientId, Pageable pageable);

    PaymentResponse getPaymentById(String paymentId);

    Page<PaymentResponse> getAllPaymentsByDate(Date paymentDate, Pageable pageable);

    Page<PaymentResponse> getAllPaymentsByType(paymentTypeEnum paymentType, Pageable pageable);

    void deletePaymentById(String paymentId);

    List<PaymentResponse> getAllPayments();
}
