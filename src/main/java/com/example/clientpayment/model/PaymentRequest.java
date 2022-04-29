package com.example.clientpayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private String paymentId;
    private String clientId;
    private String paymentProductName;
    private double paymentAmount;
    private paymentTypeEnum paymentType;
    private Date dateOfPayment;
}
