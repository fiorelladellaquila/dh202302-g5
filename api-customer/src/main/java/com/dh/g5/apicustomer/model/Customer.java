package com.dh.g5.apicustomer.model;

import com.dh.g5.apicustomer.dto.CustomerInput;
import com.dh.g5.apicustomer.dto.CustomerUpdateInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    @NotNull
    @NotBlank
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
    @NotBlank
    private Gender gender;

    @Column
    @NotNull
    @NotBlank
    private LocalDate birthDate;

    @Column
    @NotNull
    @NotBlank
    private Boolean active = true;

    public Customer(CustomerInput input) {
        this.name = input.getName();
        this.lastname = input.getLastname();
        this.birthDate = input.getBirthDate();
        this.docType = input.getDocType();
        this.documentNumber = input.getDocumentNumber();
        this.gender = input.getGender();
    }

    public Customer update(CustomerUpdateInput input) {
        this.name = input.getName();
        this.lastname = input.getLastname();
        this.birthDate = input.getBirthDate();
        this.gender = input.getGender();

        return this;
    }

    public void softDelete() {
        this.active = false;
    }
}
