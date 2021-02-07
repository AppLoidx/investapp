package com.apploidxxx.investapp.module.formatter.api;

import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Position;

public class PositionFormatter implements Formatter<Position> {
    @Override
    public String format(Position position) {
        return String.format("Имя: %s\nКод: %s\nБаланс: %.2f\nПрибыль: %s\nСр.цена актива: %s",
                position.getName(),
                position.getTicker(),
                position.getBalance(),
                position.getExpectedYield().humanReadable(),
                position.getAveragePositionPrice().humanReadable());
    }
}
