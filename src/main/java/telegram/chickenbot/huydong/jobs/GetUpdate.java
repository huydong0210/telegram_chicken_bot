package telegram.chickenbot.huydong.jobs;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import telegram.chickenbot.huydong.contsant.TelegramEndpoint;
import telegram.chickenbot.huydong.services.MessageHandler;
import telegram.chickenbot.huydong.services.impl.MessageHandlerImpl;
import telegram.chickenbot.huydong.services.impl.TelegramApiImpl;

@Service
@EnableScheduling
public class GetUpdate {

    private final TelegramApiImpl telegramApiImpl;
    private final MessageHandler messageHandler;

    public GetUpdate(TelegramApiImpl telegramApiImpl, MessageHandlerImpl messageHandlerImpl) {
        this.telegramApiImpl = telegramApiImpl;
        this.messageHandler = messageHandlerImpl;
    }

    @Scheduled(fixedRate = 2000) // Run every 2 seconds
    public void getUpdate(){
        messageHandler.handleIncomingMessage(telegramApiImpl.callAPI(TelegramEndpoint.GET_UPDATE, null));
    }
}
