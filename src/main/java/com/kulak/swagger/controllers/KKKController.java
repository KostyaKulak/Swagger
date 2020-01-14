package com.kulak.swagger.controllers;

import com.kulak.swagger.client.KKKApiClient;
import com.kulak.swagger.constants.Endpoints;
import com.kulak.swagger.entities.Contract;
import com.kulak.swagger.entities.ContractData;
import com.kulak.swagger.entities.ContractStatus;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class KKKController {
    @Autowired
    private KKKApiClient client;

    @GetMapping(value = Endpoints.CONTRACT_ENDPOINT,
        produces = APPLICATION_JSON_VALUE)
    public Contract getContract(@PathVariable final String unp) throws IOException {
        var response = client.getContract(unp).execute();
        logMessage(response);
        return response.body();
    }

    @PostMapping(value = Endpoints.CONTRACT_ENDPOINT,
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE)
    public Contract createContract(@PathVariable final String unp,
                                   @RequestBody final ContractData contractData) throws IOException {
        var response = client.createContract(unp, contractData).execute();
        logMessage(response);
        return response.body();
    }

    @PutMapping(value = Endpoints.CONTRACT_ENDPOINT,
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE)
    public Contract updateContract(@PathVariable final String unp,
                                   @RequestBody final ContractStatus status) throws IOException {
        var response = client.updateContract(unp, status).execute();
        logMessage(response);
        return response.body();
    }

    private void logMessage(final Response<?> response) {
        log.info("Response code: {}", response.code());
        log.info("Response message: {}", response.message());
    }
}