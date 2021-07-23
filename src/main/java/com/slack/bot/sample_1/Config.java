package com.slack.bot.sample_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate(){
        // HttpURLConnection을 사용해 request 생성
        // 기본생성자로 초기화시 SimpleClientHttpRequestFactory 사용
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}
