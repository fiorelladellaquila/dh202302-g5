package com.dh.g5.apicustomer.models;

import com.dh.g5.apicustomer.dto.CustomerInput;
import com.dh.g5.apicustomer.dto.CustomerUpdateInput;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "docType", "documentNumber" }) }, name = "customers")
public class Customer {
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
    @NotBlank
    private String name;
    
    @Column
    @NotNull
    @NotBlank
    private String lastname;
    
    @Column
    @NotNull
    private Gender gender;

    @Column
    @NotNull
    private LocalDate birthDate;

    @Column
    @NotNull
    private Boolean isDeleted = false;

    public Customer(CustomerInput input) {
        this.name = input.getName();
        this.lastname = input.getLastname();
        this.birthDate = LocalDate.parse(input.getBirthDate());
        this.docType = input.getDocType();
        this.documentNumber = input.getDocumentNumber();
        this.gender = input.getGender();
    }

    public Customer update(CustomerUpdateInput input) {
        this.name = input.getName();
        this.lastname = input.getLastname();
        this.birthDate = LocalDate.parse(input.getBirthDate());
        this.gender = input.getGender();

        return this;
    }

    public void softDelete() {
        this.isDeleted = true;
    }
}
