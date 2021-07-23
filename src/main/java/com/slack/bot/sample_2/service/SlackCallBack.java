package com.slack.bot.sample_2.service;

import com.slack.api.Slack;
import com.slack.api.app_backend.interactive_components.ActionResponseSender;
import com.slack.api.app_backend.interactive_components.payload.BlockActionPayload;
import com.slack.api.app_backend.interactive_components.response.ActionResponse;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.TextObject;
import com.slack.bot.sample_2.model.Vote;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SlackCallBack {

    private static Set<Vote> votes = new HashSet<>();

    private TextObject getField(Vote vote) {
        return BlockCompositions.markdownText(
                "*" + vote.getUser() + "*\n" +
                        (vote.getActionId().equals("action_success") ? "동의" : "거부"));
    }

    private LayoutBlock getFieldSection(List<TextObject> fields) {
        return Blocks.section(s -> s.fields(fields));
    }

    public String callbackVote(BlockActionPayload blockPayload) throws IOException {
        var user = blockPayload.getUser().getUsername();
        var actionId = blockPayload.getActions().get(0).getActionId();

        Vote vote = new Vote(user, actionId);
        votes.add(vote);

        var fields = votes.stream()
                .map(this::getField)
                .collect(Collectors.toList());

        List<LayoutBlock> blocks = Blocks.asBlocks(
                Blocks.divider(),
                getFieldSection(fields)
        );

        ActionResponse response = ActionResponse.builder()
                .replaceOriginal(false)
                .blocks(blocks)
                .build();

        ActionResponseSender sender = new ActionResponseSender(Slack.getInstance());
        sender.send(blockPayload.getResponseUrl(), response);

        return user;
    }

}
