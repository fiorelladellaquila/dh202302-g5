package com.dh.g5.apiwallet.models;

import com.dh.g5.apiwallet.dto.WalletInput;
import com.dh.g5.apiwallet.dto.WalletUpdateInput;
import com.sun.istack.NotNull;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "docType", "documentNumber" }) }, name = "wallets")
public class Wallet {
   @Id
   @Column(columnDefinition = "BINARY(16)")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;

   @Column
   @NotNull
   private DocType docType;

   @Column
   @NotNull
   private String documentNumber;

   @Column
   @NotNull
   private Double balance;

   @NotNull
   @ManyToOne
   @JoinColumn(name = "currencyId",nullable = false)
   private Currency currency;

   public Wallet(WalletInput input) {
      this.docType = input.getDocType();
      this.documentNumber = input.getDocumentNumber();
      this.balance = input.getBalance();
      this.currency = this.getCurrency();
   }

   public Wallet update(WalletUpdateInput input) {
      this.balance = input.getBalance();

      return this;
   }
}
