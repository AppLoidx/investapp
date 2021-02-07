package com.apploidxxx.investapp.module.tinkoff.portfolio.inner;

import com.apploidxxx.investapp.module.tinkoff.http.api.RestClient;
import com.apploidxxx.investapp.module.tinkoff.model.Models;
import com.apploidxxx.investapp.module.tinkoff.portfolio.api.PortfolioService;
import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Currencies;
import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PortfolioServiceImpl implements PortfolioService {

    private final RestClient restClient;

    @Override
    public Portfolio getPortfolio() {
        return restClient.requestGet(Models.PortfolioModel.class, "/portfolio").getPayload();
    }

    @Override
    public Currencies getCurrencies() {
        return restClient.requestGet(Models.CurrenciesModel.class, "/portfolio/currencies").getPayload();
    }

}
