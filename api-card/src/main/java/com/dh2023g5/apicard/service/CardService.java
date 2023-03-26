package com.dh2023g5.apicard.service;

import com.dh2023g5.apicard.Exceptions.CardException;

import com.dh2023g5.apicard.Exceptions.MessageError;
import com.dh2023g5.apicard.client.MarginsClient;
import com.dh2023g5.apicard.model.MovimientosTarjetaCredito;
import com.dh2023g5.apicard.model.TarjetaCredito;
import com.dh2023g5.apicard.repository.CardRepository;
import com.dh2023g5.apicard.repository.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CardService {
    private final MarginsClient marginsClient;
    private final CardRepository creditCardrepository;
    private final MovimientosRepository movimientosRepository;




    @Autowired
    public CardService(CardRepository creditCardrepository, MarginsClient marginsClient, MovimientosRepository movimientosRepository){
        this.creditCardrepository =  creditCardrepository;
        this.marginsClient = marginsClient;
        this.movimientosRepository = movimientosRepository;
    }



    public TarjetaCredito findByDocTypeAndDocNum(String docType, String docNum) throws CardException {
        return creditCardrepository.findByDocumentTypeAndDocumentNumber(docType, docNum).orElseThrow(()-> new CardException(MessageError.CUSTOMER_NOT_HAVE_CARD));
    }


    public TarjetaCredito createCard(TarjetaCredito tarjetaCredito) throws CardException {

     if(creditCardrepository.findByDocumentTypeAndDocumentNumber(tarjetaCredito.getTipoDocumento(),
             tarjetaCredito.getNumeroDocumento()).isPresent()){
       throw new CardException(MessageError.CUSTOMER_WITH_CARD);
     }

     String documentValue = tarjetaCredito.getNumeroDocumento();
     String documentType = tarjetaCredito.getTipoDocumento();
     MarginsClient.Calification calificacion = marginsClient.calculateCalification(documentType,documentValue);
     BigDecimal totalMarginCard = calificacion.getSublimits().stream().filter(sublimit ->
     sublimit.getConcept().name().equals(MarginsClient.Calification.Concept.CARD)).
     findFirst().get().getTotalMargin();
     tarjetaCredito.setLímiteCalificado(totalMarginCard);
     tarjetaCredito.setLímiteDisponible(totalMarginCard);
     tarjetaCredito.setLímiteConsumido(BigDecimal.ZERO);

        return creditCardrepository.save(tarjetaCredito);
    }
    public void debit(MovimientosTarjetaCredito movement) throws CardException {
        BigDecimal amount = movement.getCantidad().getValor();
        TarjetaCredito creditCard = creditCardrepository.findByDocumentTypeAndDocumentNumber(movement.getCobrador().getNumeroDocumento(),
        movement.getCobrador().getTipoDocumento()).orElseThrow(()-> new CardException(MessageError.CUSTOMER_NOT_HAVE_CARD));
        creditCard.setLímiteConsumido(creditCard.getLímiteConsumido().add(amount));
        creditCard.setLímiteDisponible(creditCard.getLímiteDisponible().subtract(amount));
        creditCardrepository.save(creditCard);





    }


}
