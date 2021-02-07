package com.apploidxxx.investapp.module.tinkoff.portfolio.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class Currencies {
    private List<Currency> currencies;
}
