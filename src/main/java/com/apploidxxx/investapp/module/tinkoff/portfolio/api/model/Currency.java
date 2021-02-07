package com.apploidxxx.investapp.module.tinkoff.portfolio.api.model;

import com.apploidxxx.investapp.module.tinkoff.model.CurrencyType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Currency {
    private CurrencyType currency;
    private double balance;
    private double blocked;
}
