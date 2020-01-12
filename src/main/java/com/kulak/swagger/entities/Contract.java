package com.kulak.swagger.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Contract {
    @JsonProperty("contract_id")
    private int id;
    @JsonProperty(defaultValue = "CardAccount")
    private ContractType type;
    private String number;
    @JsonProperty("date_from")
    private String dateFrom;
    @JsonProperty("date_t0")
    private String dateTo;
    private BankAccount account;
    @JsonProperty(defaultValue = "active")
    private ContractStatuses status;
    @JsonProperty("status_reason")
    private String statusReason;
}
