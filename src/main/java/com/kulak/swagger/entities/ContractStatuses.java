package com.kulak.swagger.entities;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ContractStatuses {
    NEW("new"),
    ACTIVE("active"),
    SUSPEND("suspend"),
    CLOSE("new");
    @Getter
    @JsonValue
    private String status;
}
