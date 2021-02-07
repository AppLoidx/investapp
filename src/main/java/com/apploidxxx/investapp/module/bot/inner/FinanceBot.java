package com.apploidxxx.investapp.module.bot.inner;

import com.apploidxxx.investapp.module.formatter.api.PortfolioFormatter;
import com.apploidxxx.investapp.module.tinkoff.portfolio.api.PortfolioService;
import com.apploidxxx.investapp.module.tinkoff.portfolio.api.model.Portfolio;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@Slf4j
public class FinanceBot extends TelegramLongPollingBot {
    @Value("${application.env.bot.telegram-token}")
    private String token;
    private final PortfolioService portfolioService;

    public FinanceBot(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @Override
    public String getBotUsername() {
        return "ArthurInvest";
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                final String text = message.getText();
                log.info("Received text : " + text);
                Portfolio portfolio = portfolioService.getPortfolio();

                this.execute(SendMessage
                        .builder()
                        .chatId(String.valueOf(update.getMessage().getChatId()))
                        .text(prefixText(portfolio) + " \n\n" + new PortfolioFormatter().format(portfolio))
                        .build());
            }
        }
    }

    private String prefixText(final Portfolio portfolio) {
        String text = "";
        text += "Информация по вашему профилю: \n";
        text += "Количество открытых позиций: " + portfolio.getPositions().size() + "\n";
        text += "Общая прибыль всех активов: " + portfolio.getPositions().stream().map(p -> p.expectedYield.value).reduce(Double::sum).orElse(Double.NaN) + "\n";

        return text;

    }
}
