package com.apploidxxx.investapp.module.tinkoff.portfolio.api;

import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Currencies;
import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Portfolio;

public interface PortfolioService {
    Portfolio getPortfolio();
    Currencies getCurrencies();
}
