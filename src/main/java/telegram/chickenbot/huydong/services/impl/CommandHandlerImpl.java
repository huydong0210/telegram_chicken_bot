package telegram.chickenbot.huydong.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import telegram.chickenbot.huydong.contsant.Command;
import telegram.chickenbot.huydong.services.CommandHandler;
import telegram.chickenbot.huydong.services.MessageHandler;
import telegram.chickenbot.huydong.services.TelegramSender;

import java.util.List;

@Service
public class CommandHandlerImpl implements CommandHandler {
    @Value("${telegram.search_engine_uri}")
    private String searchEngineURI;

//    @Value("${telegram.games_uri}")
//    private List<String> gameURIList;
    private TelegramSender telegramSender;

    public CommandHandlerImpl(TelegramSenderImpl telegramSender) {
        this.telegramSender = telegramSender;
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
        telegramSender.replyMessage(message.getChatId(), "/listgames : view list games of chicken \n /searh : view search engine of chicken");

    }

    @Override
    public void handleListGamesCommand(Message message) {
        telegramSender.replyMessage(message.getChatId(), "all chicken games :");


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
