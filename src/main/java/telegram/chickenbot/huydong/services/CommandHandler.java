package telegram.chickenbot.huydong.services;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandHandler {
    void handleCommand(Message message);
    void handlerStartCommand(Message message);
    void handleListGamesCommand(Message message);
    void handleSearchCommand(Message message);
    void handleNotExistedCommand(Message message);
}
