package com.dh.wallet.services;

import com.dh.wallet.client.CustomerClient;
import com.dh.wallet.dto.WalletDTO;
import com.dh.wallet.exception.MessageError;
import com.dh.wallet.exception.WalletException;
import com.dh.wallet.model.Wallet;
import com.dh.wallet.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {


    private final WalletRepository walletRepository;

    private final CustomerClient customerClient;

    public WalletService(WalletRepository walletRepository, CustomerClient customerClient) {
        this.walletRepository = walletRepository;
        this.customerClient = customerClient;
    }


    public void create(Wallet wallet) throws WalletException {
        CustomerClient.CustomerDTO customer = customerClient.getCustomer(wallet.getDocumentType(), wallet.getDocumentValue());//.orElseThrow(() -> new WalletException(MessageError.CUSTOMER_NOT_FOUND));
        if (customer ==null){
            throw new  WalletException(MessageError.WALLET_EXISTS);
        }
        if(walletRepository.findByDocumentTypeAndDocumentValueAndCurrency_Code(wallet.getDocumentType(), wallet.getDocumentValue(),wallet.getCurrency().getCode()).isPresent()){
            throw new  WalletException(MessageError.WALLET_EXISTS);
        }
        walletRepository.save(wallet);
    }

    public void updateBalance(WalletDTO walletDTO) throws Exception {
        Wallet wallet = walletRepository.findById(walletDTO.getId()).orElseThrow(() -> new WalletException(MessageError.WALLET_NOT_FOUND));
        wallet.setBalance(walletDTO.getBalance());
        walletRepository.save(wallet);
    }

    public Wallet findByDocumentAndCurrency(String documentType, String document, String code) throws Exception {
        return walletRepository.findByDocumentTypeAndDocumentValueAndCurrency_Code(documentType, document, code).orElseThrow(() -> new WalletException(MessageError.WALLET_NOT_FOUND));
    }

    public List<Wallet> findByDocument(String documentType, String document) {
        return walletRepository.findByDocumentTypeAndDocumentValue(documentType, document);
    }
}
