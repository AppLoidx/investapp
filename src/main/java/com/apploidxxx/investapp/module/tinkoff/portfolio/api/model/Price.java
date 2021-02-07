package com.apploidxxx.investapp.module.tinkoff.portfolio.api.model;

import com.apploidxxx.investapp.module.tinkoff.model.CurrencyType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Price {
    public CurrencyType currency;
    public double value;

    public String humanReadable() {
        return String.format("%.3f %s",value, currency.toString());
    }
}
