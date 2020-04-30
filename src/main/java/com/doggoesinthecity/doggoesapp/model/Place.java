package com.doggoesinthecity.doggoesapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Table
@Data
@Entity
@Builder
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @NotEmpty
    private String street;

    @NotEmpty
    private String building;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    private Integer postalCode;

    @NotEmpty
    private String country;


    private String openingHoursFrom;

    private String openingHoursTo;

    private String number;

}
