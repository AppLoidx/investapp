package com.apploidxxx.investapp.module.tinkoff.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InstrumentType {
    STOCK("Stock"),
    CURRENCY("Currency"),
    BOND("Bond"),
    ETF("Etf");

    private final String key;

    InstrumentType(String key) {
        this.key = key;
    }

    @JsonCreator
    public static InstrumentType fromString(String key) {
        if (key == null) return null;
        return InstrumentType.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getKey() {
        return this.key;
    }
}
