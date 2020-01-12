package com.kulak.swagger.client;

import com.kulak.swagger.constants.Endpoints;
import com.kulak.swagger.entities.Contract;
import com.kulak.swagger.entities.ContractData;
import com.kulak.swagger.entities.ContractStatus;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface KKKApiClient {
    @GET(Endpoints.CONTRACT_ENDPOINT)
    Call<Contract> getContract(@Path("unp") final String unp);

    @POST(Endpoints.CONTRACT_ENDPOINT)
    Call<Contract> createContract(@Path("unp") final String unp,
                                  @Body final ContractData contractData);

    @PUT(Endpoints.CONTRACT_ENDPOINT)
    Call<Contract> updateContract(@Path("unp") final String unp,
                                  @Body final ContractStatus status);
}
