package com.dh.billeteraVirtual.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.w3c.dom.DocumentType;

import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "credit-cards" )
public class CreditCard implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    private String CardNumber;
    private String documentType;
    private String documentNumber;
    private String currency;
    private BigDecimal qualifiedAmount;
    private BigDecimal ConsumedAmount;
    private BigDecimal AvailableAmount;


}
