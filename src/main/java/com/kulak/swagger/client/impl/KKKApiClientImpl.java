package com.kulak.swagger.client.impl;

import com.kulak.swagger.client.KKKApiClient;
import com.kulak.swagger.entities.Contract;
import com.kulak.swagger.entities.ContractData;
import com.kulak.swagger.entities.ContractStatus;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Service
public class KKKApiClientImpl implements KKKApiClient {
    @Value("${kkkApiUrl}")
    private String kkkApiUrl;
    private KKKApiClient baseClient;

    @Override
    public Call<Contract> getContract(final String unp) {
        return getBaseClient().getContract(unp);
    }

    @Override
    public Call<Contract> createContract(final String unp, final ContractData contractData) {
        return getBaseClient().createContract(unp, contractData);
    }

    @Override
    public Call<Contract> updateContract(final String unp, final ContractStatus status) {
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
