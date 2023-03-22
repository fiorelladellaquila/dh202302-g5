package com.dh2023g5.apicard.service;

import com.dh2023g5.apicard.client.MarginsClient;
import com.dh2023g5.apicard.model.TarjetaCredito;
import com.dh2023g5.apicard.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class CardService {

    @Autowired
    private MarginsClient client;

    @Autowired
    private CardRepository repository;


    public TarjetaCredito save(TarjetaCredito tarjetaCredito){
            String documentValue = tarjetaCredito.getNumeroDocumento();
            String documentType = tarjetaCredito.getTipoDocumento();
            MarginsClient.Calification calificacion = client.calculateCalification(documentType,documentValue);
            tarjetaCredito.setLímiteCalificado(calificacion.getTotalMargin());
            tarjetaCredito.setLímiteDisponible(calificacion.getTotalMargin());
            tarjetaCredito.setLímiteConsumido(new BigDecimal(0));

        return repository.save(tarjetaCredito);
    }

}
