package com.dh2023g5.apicard.controller;

import com.dh2023g5.apicard.Exceptions.CardException;
import com.dh2023g5.apicard.model.TarjetaCredito;
import com.dh2023g5.apicard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService creditCardService;

    @Autowired
    public CardController(CardService creditCardService) {
        this.creditCardService = creditCardService;
    }


    @GetMapping("/{TipoDocumento}/{numeroDocumento}")
    public ResponseEntity<TarjetaCredito> getCards(@PathVariable String tipoDocumento, @PathVariable String numeroDocumento) throws CardException {
        return new ResponseEntity<>(creditCardService.findByDocTypeAndDocNum(tipoDocumento,numeroDocumento),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<TarjetaCredito> createCard(@RequestBody TarjetaCredito tarjeta) throws CardException {
    return new  ResponseEntity<>(creditCardService.createCard(tarjeta), HttpStatus.CREATED);

}





}
