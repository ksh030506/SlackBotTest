package com.slack.bot.sample_1;

import com.slack.bot.SlackBotTestApplication;
import org.springframework.boot.SpringApplication;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        SlackTest2 slackTest2 = new SlackTest2();
        slackTest2.vote("둘중에 골라");
    }
}
