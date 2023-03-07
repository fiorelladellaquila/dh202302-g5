package com.dh.g5.apiwallet.services;

import com.dh.g5.apiwallet.client.CustomerFeign;
import com.dh.g5.apiwallet.dto.WalletInput;
import com.dh.g5.apiwallet.dto.WalletUpdateInput;
import com.dh.g5.apiwallet.exceptions.CustomerNotFoundException;
import com.dh.g5.apiwallet.exceptions.NotFoundException;
import com.dh.g5.apiwallet.models.Currency;
import com.dh.g5.apiwallet.models.Wallet;
import com.dh.g5.apiwallet.repository.CurrencyRepository;
import com.dh.g5.apiwallet.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WalletService  {
    private final WalletRepository walletRepository;
    private final CurrencyRepository currencyRepository;
    private final CustomerFeign customerFeign;

    public WalletService(WalletRepository walletRepository, CurrencyRepository currencyRepository, CustomerFeign customerFeign) {
        this.walletRepository = walletRepository;
        this.currencyRepository = currencyRepository;
        this.customerFeign = customerFeign;
    }


    public Wallet create(WalletInput input) throws CustomerNotFoundException {
        if (customerFeign.getCustomer( input.getDocType(), input.getDocumentNumber()).size() == 0) {
            throw new CustomerNotFoundException("Customer not found");
        }

        Currency currency = currencyRepository.save(input.getCurrency());
        input.setCurrency(currency);
        return walletRepository.save(
                new Wallet(input)
        );
    }

    public Wallet update(WalletUpdateInput input, UUID walletId) throws NotFoundException {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(
                () -> new NotFoundException("Wallet " + walletId +" Not Found")
        );

        return walletRepository.save(wallet.update(input));
    }


}
