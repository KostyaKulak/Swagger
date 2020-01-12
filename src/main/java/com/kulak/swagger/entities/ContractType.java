package com.kulak.swagger.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ContractType {
    CONTRACT_TYPE("CardAccount");
    @Getter
    private String type;
}
