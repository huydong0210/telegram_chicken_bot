package telegram.chickenbot.huydong.services;

import org.json.JSONObject;

import java.util.HashMap;

public interface TelegramApi {
    JSONObject callAPI(String endPoints, HashMap<String, String> params);
}
