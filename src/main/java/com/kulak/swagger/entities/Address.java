package com.kulak.swagger.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private int postcode;
    private String region;
    private String district;
    private String cityType;
    private String city;
    private String streetType;
    private String street;
    private int house;
    private String building;
    private int flat;
}
