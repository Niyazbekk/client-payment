package com.example.clientpayment.repository;

import com.example.clientpayment.model.paymentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "client-payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    @Id
    @Field(type = FieldType.Keyword)
    private String paymentId;

    @Field(type = FieldType.Keyword)
    private String clientId;

    @Field(type = FieldType.Keyword)
    private String paymentProductName;

    @Field(type = FieldType.Long)
    private double paymentAmount;

    @Field(type = FieldType.Keyword)
    private paymentTypeEnum paymentType;

    @Field(type = FieldType.Date, format = DateFormat.basic_date) // YY-MM-dd
    private String dateOfPayment;

}
