package com.apploidxxx.investapp.module.tinkoff.model;

public enum CurrencyType {
    RUB {
        @Override
        public String toString() {
            return "₽";
        }
    }, USD {
        @Override
        public String toString() {
            return "$";
        }
    }, EUR, GBP, HKD, CHF, JPY, CNY, TRY
}
