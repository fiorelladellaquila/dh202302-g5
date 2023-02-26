package com.dh.g5.apicustomer.dto;

import com.dh.g5.apicustomer.models.DocType;
import com.dh.g5.apicustomer.models.Gender;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInput {

    @NotNull
    private DocType docType;

    @NotNull
    @NotBlank
    private String documentNumber;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    private Gender gender;

    @NotNull
    @NotBlank
    private String birthDate;

}
