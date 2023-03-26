package com.dh2023g5.apicard.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Id;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "tarjeta_credito")
public class TarjetaCredito {
    @Id
    private String numeroTarjeta;
    private String TipoDocumento;
    private String numeroDocumento;
    private String   moneda;
    private BigDecimal límiteCalificado;
    private BigDecimal límiteConsumido;
    private BigDecimal límiteDisponible;
}
