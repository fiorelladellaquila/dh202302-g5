package com.dh.billeteraVirtual.service;

import com.dh.billeteraVirtual.client.MarginsClient;
import com.dh.billeteraVirtual.models.CreditCard;
import com.dh.billeteraVirtual.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditCardService {


    private CreditCardRepository creditCardRepository;

    private MarginsClient marginsClient;

    public CreditCardService(CreditCardRepository creditCardRepository, MarginsClient marginsClient) {
        this.creditCardRepository = creditCardRepository;
        this.marginsClient = marginsClient;
    }

    private List<CreditCard> findByQualifiedAmountAndAvailableAmount(BigDecimal QualifiedAmount, BigDecimal AvailableAmount){
        return creditCardRepository.findByQualifiedAmountAndAvailableAmount(QualifiedAmount, AvailableAmount);
    }

    public void createCreditCard (String documentType, String documentValue){
        var response = marginsClient.calculateCalification(documentType, documentValue);
        var calificado = response.getSublimits().stream().filter(sublimit -> sublimit.getConcept().equals(MarginsClient.Calification.Concept.CARD)).findFirst().get().getTotalMargin();
        CreditCard newCard = new CreditCard();
        newCard.setCardNumber("1234" + documentValue);
        newCard.setDocumentType(documentType);
        newCard.setDocumentNumber(documentValue);
        newCard.setCurrency("USD");
        newCard.setQualifiedAmount(calificado);
        newCard.setConsumedAmount(new BigDecimal(0));

        newCard.setAvailableAmount(calificado);


        creditCardRepository.save(newCard);
    }






}
