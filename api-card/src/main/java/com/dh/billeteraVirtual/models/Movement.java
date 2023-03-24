package com.dh.billeteraVirtual.models;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serial;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movements" )
public class Movement {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    private String cardNumber;
    private Type type;

    private Currency currency;

    private LocalDate operationDate;

    private DebtCollector debtCollector;

    private String description;

    private List<Detail> items;

    private Status status;

    public void setWalletCommission(double importe) {
        this.walletCommission = importe * 0.5;
    }

    private double walletCommission;




    @Getter
    @Setter
    @Builder
    public static class Currency {

        private String name;
        private double value;
    }

    @Getter
    @Setter
    @Builder
    public static class DebtCollector {

        private String documentType;
        private String documentNumber;
        private String businessName;
    }

    @Getter
    @Setter
    @Builder
    public static class Detail {

        private String name;
        private int quantity;
        private double unitPrice;
        private double subtotal;

    }




}
