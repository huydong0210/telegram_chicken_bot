package telegram.chickenbot.huydong.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import telegram.chickenbot.huydong.DTO.Update;
import telegram.chickenbot.huydong.config.Redis;
import telegram.chickenbot.huydong.contsant.MessageEntityType;
import telegram.chickenbot.huydong.contsant.TelegramEndpoint;
import telegram.chickenbot.huydong.contsant.TelegramParamKey;
import telegram.chickenbot.huydong.services.CommandHandler;
import telegram.chickenbot.huydong.services.MessageHandler;
import telegram.chickenbot.huydong.services.TelegramApi;
import telegram.chickenbot.huydong.services.TelegramSender;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

@Service
public class MessageHandlerImpl implements MessageHandler {
    private final ObjectMapper objectMapper;
    @Qualifier("systemStartTime")
    private final Long systemStartTime;
    private HashMap<Long, Integer> handledChat;
    private final TelegramApi telegramApi;
    private final CommandHandler commandHandler;
    private final TelegramSender telegramSender;

    public MessageHandlerImpl(ObjectMapper objectMapper, Long systemStartTime
            , TelegramApiImpl telegramApi, CommandHandlerImpl commandHandler,
                              TelegramSenderImpl telegramSender

    ) {
        this.objectMapper = objectMapper;
        this.systemStartTime = systemStartTime;
        handledChat = Redis.getInstance().getHandledChat();
        this.telegramApi = telegramApi;
        this.commandHandler = commandHandler;
        this.telegramSender = telegramSender;
    }

    private final String RESULT_KEY = "result";

    @Override
    public void handleIncomingMessage(JSONObject jsonObject) {
        String result = jsonObject.get(RESULT_KEY).toString();
        try {
            List<Update> updateList = objectMapper.readValue(result, new TypeReference<List<Update>>() {
            });
            List<Message> messageList = updateList.stream().map(update -> update.getMessage()).filter(message -> {
                if (message == null) {
                    return false;
                }
                if (!compareDateOfChatToSystemStartTime(message.getDate().longValue(), systemStartTime)) {
                    return false;
                }
                if (handledChat.get(message.getChatId()) != null && handledChat.get(message.getChatId()) >= message.getMessageId()) {
                    return false;
                }
                return true;
            }).toList();
            messageList.stream().forEach(message -> {
                this.handleMessage(message);
                this.handledChat.put(message.getChatId(), message.getMessageId());
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handleMessage(Message message) {
        if (message.getEntities() == null) {
            telegramSender.replyMessage(message.getChatId(), "invalid command");
        } else {
            switch (message.getEntities().get(0).getType()) {
                case MessageEntityType.BOT_COMMAND:
                    commandHandler.handleCommand(message);
                    break;
                case MessageEntityType.HASHTAG:
                    break;
            }
        }

    }

    private boolean compareDateOfChatToSystemStartTime(Long dateOfChat, Long systemStartTime) {
        Instant instantOfChat = Instant.ofEpochSecond(dateOfChat);
        Instant instantOfSystem = Instant.ofEpochMilli(systemStartTime);
        if (instantOfSystem.isBefore(instantOfChat)) {
            return true;
        } else {
            return false;
        }
    }
}
