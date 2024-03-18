package telegram.chickenbot.huydong.config;

import java.util.HashMap;

public class Redis {
    private HashMap<Long, Integer> handledChat;
    private static volatile Redis instance;
    public static Redis getInstance() {
        if (instance == null){
            synchronized (Redis.class){
                if (instance == null){
                    instance = new Redis();
                }
            }
        }
        return instance;
    }

    private Redis(){
        handledChat = new HashMap<>();
    }

    public HashMap<Long, Integer> getHandledChat() {
        return handledChat;
    }
}
