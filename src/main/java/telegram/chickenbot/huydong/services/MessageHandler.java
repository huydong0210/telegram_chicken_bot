package telegram.chickenbot.huydong.services;

import org.json.JSONObject;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;

public interface MessageHandler {
    void handleIncomingMessage(JSONObject jsonObject);
    void handleMessage(Message message);
}
