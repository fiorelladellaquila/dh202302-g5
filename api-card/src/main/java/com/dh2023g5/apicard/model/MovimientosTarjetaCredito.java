package com.dh2023g5.apicard.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Document(collection = "movimientos_tarjeta_credito")
@Builder
public class MovimientosTarjetaCredito {
    @Id
    private String idMovimiento;
    private String numeroDeTarjeta;
    private TipoMovimiento tipo;
    private String   moneda;

}


