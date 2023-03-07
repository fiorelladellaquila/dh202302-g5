package com.dh.g5.apiwallet.controllers;

import com.dh.g5.apiwallet.dto.WalletInput;
import com.dh.g5.apiwallet.dto.WalletUpdateInput;
import com.dh.g5.apiwallet.exceptions.BadRequestException;
import com.dh.g5.apiwallet.exceptions.CustomerNotFoundException;
import com.dh.g5.apiwallet.exceptions.NotFoundException;
import com.dh.g5.apiwallet.models.DocType;
import com.dh.g5.apiwallet.models.Wallet;
import com.dh.g5.apiwallet.services.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }


    @PostMapping
    public ResponseEntity<Wallet> create(@RequestBody @Valid WalletInput wallet) throws BadRequestException, CustomerNotFoundException {
        return ResponseEntity.ok(walletService.create(wallet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wallet> update(@PathVariable UUID id, @RequestBody @Valid WalletUpdateInput wallet) throws NotFoundException {
        return ResponseEntity.ok(walletService.update(wallet, id));
    }

}
