package com.apploidxxx.investapp.module.tinkoff.portfolio.api.model;

import com.apploidxxx.investapp.module.tinkoff.model.InstrumentType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Position {
    public String figi;
    public String ticker;
    public String isin;
    public InstrumentType instrumentType;
    public double balance;
    public int lots;
    public Price expectedYield;
    public Price averagePositionPrice;
    public String name;

}
