package com.dh.g5.apicustomer.dto;

import com.dh.g5.apicustomer.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUpdateInput {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    private String gender;

    @NotNull
    @NotBlank
    private String birthDate;

}
