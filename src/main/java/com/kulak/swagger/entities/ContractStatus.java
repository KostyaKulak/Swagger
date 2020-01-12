package com.kulak.swagger.entities;

import lombok.Data;

@Data
public class ContractStatus {
    private ContractStatuses status;
    private String reason;
}
