package telegram.chickenbot.huydong.services;

import org.json.JSONObject;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;

public interface MessageHandler {
    void handleIncomingMessage(JSONObject jsonObject);
    void replyMessage(Long chatId, String text, HashMap<String, String> optional);
    void replyMessage(Long chatId, String text);
}
