package com.slack.bot.sample_1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class SlackTest {

    private final RestTemplate restTemplate;

    //@PostConstruct
    public void send() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "실험용 쥐");
        payload.put("text", "테스트용 메시지 <https://zkdlu.tistory.com|링크>");
        payload.put("icon_url", "https://avatars.githubusercontent.com/u/22608617?s=60&v=4");

        restTemplate.postForObject("https://hooks.slack.com/services/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", payload, String.class);
    }
}
