package com.dh2023g5.apicard.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Document(collection = "tarjeta_credito")
@Builder
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
