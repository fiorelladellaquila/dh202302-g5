package com.dh.g5.apiwallet.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "currencies")
public class Currency {
   @Id
   @Column(columnDefinition = "BINARY(16)")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;

   @Column
   @NotBlank
   private String countryCode;

   @Column
   @NotBlank
   private String description;

}
