package com.slack.bot.sample_2.controller;

import com.slack.api.app_backend.interactive_components.payload.BlockActionPayload;
import com.slack.api.util.json.GsonFactory;
import com.slack.bot.sample_2.service.SlackCallBack;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SlackController {

    private final RestTemplate restTemplate;
    private SlackCallBack slackCallBack = new SlackCallBack();

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String callback(@RequestParam String payload) throws IOException {
        var blockPayload = GsonFactory.createSnakeCase().fromJson(payload, BlockActionPayload.class);
        return slackCallBack.callbackVote(blockPayload);
    }

}
