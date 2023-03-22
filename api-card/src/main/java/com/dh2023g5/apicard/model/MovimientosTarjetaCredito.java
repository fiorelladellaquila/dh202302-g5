package com.dh2023g5.apicard.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "movimientos_tarjeta_credito")
@Builder
public class MovimientosTarjetaCredito {
    @Id
    private String idMovimiento;
    private String numeroDeTarjeta;
    private TipoMovimiento tipo;
    private  MovimientosTarjetaCredito.Moneda moneda;
    private LocalDateTime fechaOperacion;
    private MovimientosTarjetaCredito.Cobrador cobrador;
    private MovimientosTarjetaCredito.Detallecompra detallecompra;
    private final static double COMISION = 0.005;


    @Getter
    @Setter
    @Builder
    public static class Moneda{
        private String nombre;
        private BigDecimal valor;


    }


    @Getter
    @Setter
    @Builder
    public static class Cobrador{
        private String tipoDocumento;
        private String numeroDocumento;
        private String razonSocial;

    }

    public static class Detallecompra{
        private String nombre;
        private Integer cantidad;
        private BigDecimal importeUnitario;
        private BigDecimal importeSubtotal;
        private Estado estado;

    }





}


