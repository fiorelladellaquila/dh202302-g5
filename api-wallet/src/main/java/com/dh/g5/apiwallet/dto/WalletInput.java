package com.dh.g5.apiwallet.dto;

import com.dh.g5.apiwallet.models.Currency;
import com.dh.g5.apiwallet.models.DocType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletInput {

    @NotNull
    private DocType docType;

    @NotNull
    @NotBlank
    private String documentNumber;

    @NotNull
    private Double balance;

    @NotNull
    private Currency currency;

}
