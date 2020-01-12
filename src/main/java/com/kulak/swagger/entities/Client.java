package com.kulak.swagger.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {
    @JsonProperty("client_id")
    private int id;
    private int unp;
    private String name;
    private String affiliate;
    private String form;
    @JsonProperty("legal_address")
    private Address legalAddress;
    @JsonProperty("postal_address")
    private Address postalAddress;
}
