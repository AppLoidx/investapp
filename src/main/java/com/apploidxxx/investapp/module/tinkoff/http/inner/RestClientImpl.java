package com.apploidxxx.investapp.module.tinkoff.http.inner;

import com.apploidxxx.investapp.module.tinkoff.http.api.RestClient;
import com.apploidxxx.investapp.module.tinkoff.model.TinkoffResponse;
import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Portfolio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
class RestClientImpl implements RestClient {

    private final RestTemplate restTemplate;
    @Value("${application.env.tinkoff.api}")
    private String restUri;

    @Value("${application.env.tinkoff.secured-key}")
    private String token;

    private HttpHeaders headers() {

        final HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        return headers;
    }

    @Override
    public <T> T requestGet(Class<T> clazz, String path) {
        HttpEntity<String> request = new HttpEntity<>(headers());
        ResponseEntity<T> response = restTemplate.exchange(restUri + "portfolio", HttpMethod.GET, request, clazz);
        return response.getBody();
    }
}
