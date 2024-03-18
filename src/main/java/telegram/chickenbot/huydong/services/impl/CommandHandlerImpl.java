package telegram.chickenbot.huydong.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import telegram.chickenbot.huydong.contsant.Command;
import telegram.chickenbot.huydong.contsant.TelegramParamKey;
import telegram.chickenbot.huydong.services.CommandHandler;
import telegram.chickenbot.huydong.services.MessageHandler;
import telegram.chickenbot.huydong.services.TelegramSender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CommandHandlerImpl implements CommandHandler {
    @Value("${telegram.search_engine_uri}")
    private String searchEngineURI;

    @Value("${telegram.games_uri}")
    private List<String> gameURIList;
    private TelegramSender telegramSender;
    private final ObjectMapper objectMapper;

    public CommandHandlerImpl(TelegramSenderImpl telegramSender, ObjectMapper objectMapper) {
        this.telegramSender = telegramSender;
        this.objectMapper = objectMapper;
    }

    @Override
    public void handleCommand(Message message) {
        switch (message.getText()) {
            case Command.START:
                this.handlerStartCommand(message);
                break;
            case Command.LIST_GAME:
                this.handleListGamesCommand(message);
                break;
            case Command.SEARCH:
                this.handleSearchCommand(message);
                break;
            default: this.handleNotExistedCommand(message);
        }
    }

    @Override
    public void handlerStartCommand(Message message) {
        telegramSender.replyMessage(message.getChatId(), "/listgames : view list games of chicken \n /search : view search engine of chicken");

    }

    @Override
    public void handleListGamesCommand(Message message) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
        gameURIList.stream().forEach(uri -> {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            WebAppInfo webAppInfo =new WebAppInfo();
            webAppInfo.setUrl(uri);
            inlineKeyboardButton.setText("game " + (gameURIList.indexOf(uri)));
            inlineKeyboardButton.setWebApp(webAppInfo);
            inlineKeyboardButton.setUrl(uri);
            inlineKeyboardButtonList.add(inlineKeyboardButton);
        });
        List<List<InlineKeyboardButton>> keyBoardList = new ArrayList<>();
        keyBoardList.add(inlineKeyboardButtonList);
        inlineKeyboardMarkup.setKeyboard(keyBoardList);
        HashMap<String, String> params = new HashMap<>();
        try {
            params.put(TelegramParamKey.REPLY_MARKUP, objectMapper.writeValueAsString(inlineKeyboardMarkup) );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        telegramSender.replyMessage(message.getChatId(), "here is chicken's games", params);

    }

    @Override
    public void handleSearchCommand(Message message) {
        String text = "here is my engine: " + searchEngineURI;
        telegramSender.replyMessage(message.getChatId(), text);
    }

    @Override
    public void handleNotExistedCommand(Message message) {
        telegramSender.replyMessage(message.getChatId(), "invalid command");
    }


}
