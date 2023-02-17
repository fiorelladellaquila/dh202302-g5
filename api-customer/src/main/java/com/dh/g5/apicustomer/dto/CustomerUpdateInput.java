package com.dh.g5.apicustomer.dto;

import com.dh.g5.apicustomer.model.DocType;
import com.dh.g5.apicustomer.model.Gender;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CustomerUpdateInput {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String lastname;
    @NotNull
    @NotBlank
    private Gender gender;
    @NotNull
    @NotBlank
    private LocalDate birthDate;

    @JsonCreator
    public CustomerUpdateInput(String name, String lastname, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
