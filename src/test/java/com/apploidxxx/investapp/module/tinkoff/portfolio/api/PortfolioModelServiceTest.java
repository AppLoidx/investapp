package com.apploidxxx.investapp.module.tinkoff.portfolio.api;

import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Portfolio;
import com.apploidxxx.investapp.testutil.SampleReader;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PortfolioModelServiceTest {

    @Value("${application.env.tinkoff.api}")
    private String testApiUri;

    private MockRestServiceServer mockServer;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PortfolioService portfolioService;

    @BeforeEach
    void setUp() {
        assertNotNull(restTemplate);
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @SneakyThrows
    @Test
    void getPortfolio() {
        mockServer.expect(ExpectedCount.once(),
                requestTo(testApiUri + "portfolio"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(SampleReader.readSample("portfolio.json"))
                );

        Portfolio portfolio = portfolioService.getPortfolio();
    }
}