package com.dh2023g5.apicard.controller;

import com.dh2023g5.apicard.model.TarjetaCredito;
import com.dh2023g5.apicard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService service;


public ResponseEntity<TarjetaCredito> createCard(@RequestBody TarjetaCredito tarjeta) {

    return new  ResponseEntity<> (service.save(tarjeta), HttpStatus.CREATED);

}





}
