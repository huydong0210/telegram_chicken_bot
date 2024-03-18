package telegram.chickenbot.huydong.services.impl;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import telegram.chickenbot.huydong.contsant.MessageEntityType;
import telegram.chickenbot.huydong.contsant.TelegramEndpoint;
import telegram.chickenbot.huydong.contsant.TelegramParamKey;
import telegram.chickenbot.huydong.services.TelegramApi;
import telegram.chickenbot.huydong.services.TelegramSender;

import java.util.HashMap;
@Service
public class TelegramSenderImpl implements TelegramSender {
    private final TelegramApi telegramApi;

    public TelegramSenderImpl(TelegramApiImpl telegramApi) {
        this.telegramApi = telegramApi;
    }

    @Override
    public void replyMessage(Long chatId, String text, HashMap<String, String> params) {
        if (params == null){
            this.replyMessage(chatId, text);
        } else {
            params.put(TelegramParamKey.CHAT_ID, chatId.toString());
            params.put(TelegramParamKey.TEXT, text);
            telegramApi.callAPI(TelegramEndpoint.SEND_MESSAGE, params);
        }
    }

    @Override
    public void replyMessage(Long chatId, String text) {
        HashMap<String, String> params = new HashMap<>();
        params.put(TelegramParamKey.CHAT_ID, chatId.toString());
        params.put(TelegramParamKey.TEXT, text);
        telegramApi.callAPI(TelegramEndpoint.SEND_MESSAGE, params);
    }
}
