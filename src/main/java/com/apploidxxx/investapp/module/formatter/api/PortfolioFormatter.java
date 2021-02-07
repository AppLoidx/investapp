package com.apploidxxx.investapp.module.formatter.api;

import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Portfolio;
import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Position;

public class PortfolioFormatter implements Formatter<Portfolio> {
    @Override
    public String format(Portfolio portfolio) {
        StringBuilder positionsFormatted = new StringBuilder();
        PositionFormatter positionFormatter = new PositionFormatter();
        for (Position position : portfolio.getPositions()) {
            positionsFormatted.append(positionFormatter.format(position));
            positionsFormatted.append("\n\n");
        }
        return String.format("Позиции:\n\n%s", positionsFormatted.toString());
    }
}
