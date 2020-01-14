package com.kulak.swagger.entities;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ContractType {
    CONTRACT_TYPE("CardAccount");
    @Getter
    @JsonValue
    private String type;
}