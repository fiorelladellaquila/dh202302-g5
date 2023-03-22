package com.dh.g5.apicustomer.models;

import com.dh.g5.apicustomer.dto.CustomerInput;
import com.dh.g5.apicustomer.dto.CustomerUpdateInput;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Getter
@Setter
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
    private String docType;

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
    private String gender;



    public Customer(CustomerInput input) {
        this.name = input.getName();
        this.lastname = input.getLastname();

        this.docType = input.getDocType();
        this.documentNumber = input.getDocumentNumber();
        this.gender = input.getGender();
    }

    public Customer update(CustomerUpdateInput input) {
        this.name = input.getName();
        this.lastname = input.getLastname();

        this.gender = input.getGender();

        return this;
    }


}
