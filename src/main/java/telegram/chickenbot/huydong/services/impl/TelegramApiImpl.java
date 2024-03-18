package telegram.chickenbot.huydong.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegram.chickenbot.huydong.services.TelegramApi;

import java.util.HashMap;

@Service
public class TelegramApiImpl implements TelegramApi {
    @Value("${telegram.base_url}")
    private String baseURL;
    @Value("${telegram.token}")
    private String token;
    private final Logger log = LoggerFactory.getLogger(TelegramApiImpl.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;


    public TelegramApiImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }
    @Override
    public JSONObject callAPI(String endPoints, HashMap<String, String> params) {
        try {
            ResponseEntity <String> response = this.restTemplate.exchange(
                    generateEndpoints(endPoints,params),
                    HttpMethod.GET,
                    null,
                    String.class
            );
            return new JSONObject(response.getBody().toString());
        } catch (Exception e){
            log.error("rest endpoints" + endPoints + " error");
            log.error(e.getMessage());
        }
        return null;
    }

    private String generateEndpoints(String endPoints, HashMap<String, String> params) {
        StringBuilder result = new StringBuilder();
        result.append(baseURL).append(token).append(endPoints);
        if (params!= null){
            result.append("?");
            params.keySet().stream().forEach(key -> {
                result.append(key).append("=").append(params.get(key)).append("&");
            });
            result.deleteCharAt(result.length() - 1);
        }


        return result.toString();
    }
}
