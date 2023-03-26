package com.dh2023g5.apicard.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document(collection = "movimientos_tarjeta_credito")
@Builder
public class MovimientosTarjetaCredito {
    @Id
    private String id;
    private String numeroDeTarjeta;
    private TipoMovimiento tipo;
    private Cantidad cantidad;
    private LocalDateTime fechaOperacion;
    private Cobrador cobrador;
    private List<Detallecompra> detallecompra;
    private Boolean estado;
    private final static double COMISION = 0.005;


    @Getter
    @Setter
    @Builder
    public static class Cantidad{
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

    @Getter
    @Setter
    @Builder
    public static class Detallecompra{
        private String nombre;
        private Integer cantidad;
        private BigDecimal importeUnitario;
        private BigDecimal importeSubtotal;

    }

    public static enum TipoMovimiento{
        DEBITO, CREDITO;
    }





}


