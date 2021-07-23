package com.slack.bot;

import com.slack.bot.sample_2.service.SlackTest2;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SlackBotTestApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SlackBotTestApplication.class, args);
    }

}
