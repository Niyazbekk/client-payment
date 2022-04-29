package com.example.clientpayment.repository;

import com.example.clientpayment.model.paymentTypeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PaymentRepository extends ElasticsearchRepository<PaymentEntity, String> {
    Page<PaymentEntity> getPaymentEntitiesByPaymentType(paymentTypeEnum paymentType, Pageable pageable);

    PaymentEntity getPaymentEntityByPaymentId(String paymentId);

    void deletePaymentEntityByPaymentId(String paymentId);

    Page<PaymentEntity> getPaymentEntitiesByDateOfPayment(Date paymentDate, Pageable pageable);

    Page<PaymentEntity> getPaymentEntitiesByClientId(String clientId, Pageable pageable);

    List<PaymentEntity> getPaymentEntityBy();
}
