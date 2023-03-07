package com.dh.g5.apicustomer.dto;

import com.dh.g5.apicustomer.models.DocType;
import com.dh.g5.apicustomer.models.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    //@JsonFormat(pattern="yyyy-MM-dd")
    private String birthDate;

}
