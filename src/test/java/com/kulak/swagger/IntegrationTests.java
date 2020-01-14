package com.kulak.swagger;

import com.kulak.swagger.entities.Contract;
import com.kulak.swagger.entities.ContractData;
import com.kulak.swagger.entities.ContractStatus;
import com.kulak.swagger.entities.ContractStatuses;
import com.kulak.swagger.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class IntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeAll
    static void setup() {
        log.info(">> Setup");
    }

    @Test
    public void testCreateContentAndStatusCode() {
        log.info(">> Assert creating contract and status code");
        val contract = JsonUtils.fetchObject("templates/contract.json", ContractData.class);
        val entity = restTemplate.postForEntity("/api/v1/client/101015738/contract/", contract, Contract.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isNotNull();
    }

    @Test
    public void testGetContentAndStatusCode() {
        log.info(">> Assert getting contract and status code");
        val entity = restTemplate.getForEntity("/api/v1/client/101015738/contract/", Contract.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isNotNull();
    }

    @Test
    public void testUpdateContentAndStatusCode() {
        log.info(">> Assert updating contract and status code");
        restTemplate.put("/api/v1/client/101015738/contract/",
            new ContractStatus(ContractStatuses.ACTIVE, "Заключение договора"),
            Contract.class);
    }

    @AfterAll
    static void teardown() {
        log.info(">> Tear down");
    }
}
