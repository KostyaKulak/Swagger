package com.kulak.swagger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class KKKTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getContractTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/client/101015738/contract/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}