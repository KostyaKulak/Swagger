package com.kulak.swagger.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kulak.swagger.client.KKKApiClient;
import com.kulak.swagger.entities.Contract;
import com.kulak.swagger.entities.ContractData;
import com.kulak.swagger.entities.ContractStatus;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class KKKApiClientImpl implements KKKApiClient {
    @Value("${kkkApiUrl}")
    private String kkkApiUrl;
    private KKKApiClient baseClient;

    @Override
    public Call<Contract> getContract(final String unp) {
        log.debug("Getting contract by unp {}", unp);
        return getBaseClient().getContract(unp);
    }

    @Override
    public Call<Contract> createContract(final String unp, final ContractData contractData) {
        log.debug("Create contract by unp {} with next data:", unp);
        try {
            log.debug(new ObjectMapper().writeValueAsString(contractData));
        } catch (JsonProcessingException e) {
            log.warn("Error logging contract data.");
        }
        return getBaseClient().createContract(unp, contractData);
    }

    @Override
    public Call<Contract> updateContract(final String unp, final ContractStatus status) {
        log.debug("Update contract by unp {} with next data:", unp);
        try {
            log.debug(new ObjectMapper().writeValueAsString(status));
        } catch (JsonProcessingException e) {
            log.warn("Error logging contract status.");
        }
        return getBaseClient().updateContract(unp, status);
    }

    private synchronized KKKApiClient getBaseClient() {
        if (baseClient == null) {
            baseClient = new Retrofit.Builder()
                .client(createOkHttp())
                .baseUrl(kkkApiUrl)
                .addConverterFactory(JacksonConverterFactory.create())
//                    .addCallAdapterFactory()
                .build()
                .create(KKKApiClient.class);
        }
        return baseClient;

    }

    private OkHttpClient createOkHttp() {
        return new OkHttpClient.Builder()
            .readTimeout(100000, TimeUnit.SECONDS)
            .connectTimeout(100000, TimeUnit.SECONDS)
            .writeTimeout(100000, TimeUnit.SECONDS)
            .build();
    }
}
