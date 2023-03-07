package com.dh.g5.apicustomer.dto;

import com.dh.g5.apicustomer.models.DocType;
import com.dh.g5.apicustomer.models.Gender;
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


    private String documentNumber;


    private String name;


    private String lastname;


    private Gender gender;




}
