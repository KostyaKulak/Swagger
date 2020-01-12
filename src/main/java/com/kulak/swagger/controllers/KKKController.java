package com.kulak.swagger.controllers;

import com.kulak.swagger.client.KKKApiClient;
import com.kulak.swagger.constants.Endpoints;
import com.kulak.swagger.entities.Contract;
import com.kulak.swagger.entities.ContractData;
import com.kulak.swagger.entities.ContractStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Body;
import retrofit2.http.Path;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class KKKController {
    @Autowired
    private KKKApiClient client;

    @GetMapping(Endpoints.CONTRACT_ENDPOINT)
    public Contract getContract(@RequestParam("unp") final String unp) throws IOException {
        return client.getContract(unp).execute().body();
    }

    @PostMapping(Endpoints.CONTRACT_ENDPOINT)
    public Contract createContract(@Path("unp") final String unp,
                                   @Body final ContractData contractData) throws IOException {
        return client.createContract(unp, contractData).execute().body();
    }

    @PutMapping(Endpoints.CONTRACT_ENDPOINT)
    public Contract updateContract(@Path("unp") final String unp,
                                   @Body final ContractStatus status) throws IOException {
        return client.updateContract(unp, status).execute().body();
    }
}