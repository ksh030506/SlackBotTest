package com.slack.bot.sample_2.main;

import com.slack.bot.SlackBotTestApplication;
import com.slack.bot.sample_2.service.SlackTest2;
import org.springframework.boot.SpringApplication;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        SlackTest2 slackTest2 = new SlackTest2();
        slackTest2.vote("골라 골라");
    }
}
