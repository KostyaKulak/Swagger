package com.kulak.swagger.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContractStatus {
    private ContractStatuses status;
    private String reason;
}
