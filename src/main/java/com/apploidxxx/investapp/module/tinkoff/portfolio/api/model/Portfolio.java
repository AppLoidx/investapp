package com.apploidxxx.investapp.module.tinkoff.portfolio.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Portfolio {
    public List<Position> positions;
}
