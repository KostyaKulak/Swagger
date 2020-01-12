package com.kulak.swagger.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ContractStatuses {
    NEW("new"),
    ACTIVE("active"),
    SUSPEND("suspend"),
    CLOSE("new");
    @Getter
    private String status;
}
