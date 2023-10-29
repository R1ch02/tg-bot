package ru.application.controller;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.validation.Valid;


@Component
@Log4j
public class TelegramBot extends TelegramLongPollingBot {

    private String botName = "bilyuba_telegram_bot";

    private String botToken = "6503374595:AAGmxwGPkQTTkuh7VQyy4bSN7LfHsM3Jzoo";
    @Override
    public String getBotUsername() {
        return "bilyuba_telegram_bot";
    }

    @Override
    public String getBotToken() {
        return "6503374595:AAGmxwGPkQTTkuh7VQyy4bSN7LfHsM3Jzoo";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var originalMessage = update.getMessage();
        log.debug(originalMessage.getText());

        var response = new SendMessage();
        response.setChatId(originalMessage.getChatId().toString());
        response.setText("Hello from bot");
        sendAnswerMessage(response);
    }

    public void sendAnswerMessage(SendMessage message){
        if(message != null){
            try {
                execute(message);
            } catch (TelegramApiException e) {
                log.error(e);
            }
        }
    }
}
