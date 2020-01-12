package com.kulak.swagger.entities;

import lombok.Data;

@Data
public class BankAccount {
    private String bic;
    private String iban;
    private String name;
}
