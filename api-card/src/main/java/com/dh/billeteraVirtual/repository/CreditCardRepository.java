package com.dh.billeteraVirtual.repository;

import com.dh.billeteraVirtual.models.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, UUID> {

    List<CreditCard> findByQualifiedAmountAndAvailableAmount(BigDecimal QualifiedAmount, BigDecimal AvailableAmount);

}
