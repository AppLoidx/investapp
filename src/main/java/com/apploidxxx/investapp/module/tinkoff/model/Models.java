package com.apploidxxx.investapp.module.tinkoff.model;

import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Currencies;
import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Portfolio;

public class Models {
    public static class PortfolioModel extends TinkoffResponse<Portfolio> {};
    public static class CurrenciesModel extends TinkoffResponse<Currencies> {};

}
