package com.slack.bot.sample_1;


import com.slack.api.Slack;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElement;
import com.slack.api.model.block.element.BlockElements;
import com.slack.api.webhook.WebhookPayloads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

public class SlackTest2 {
    private LayoutBlock getHeader(String text) {
        return Blocks.header(h -> h.text(
                plainText(pt -> pt.emoji(true)
                        .text(text))));
    }

    private LayoutBlock getSection(String message) {
        return Blocks.section(s -> s.text(
                BlockCompositions.markdownText(message)));
    }

    private BlockElement getActionButton(String plainText, String value, String style, String actionId) {
        return BlockElements.button(b -> b.text(plainText(plainText, true))
                .value(value)
                .style(style)
                .actionId(actionId));
    }

    private List<BlockElement> getActionBlocks() {
        List<BlockElement> actions = new ArrayList<>();
        actions.add(getActionButton("확인", "ok", "primary", "action_success"));
        actions.add(getActionButton("취소", "fail", "danger", "action_fail"));
        return actions;
    }

    public String vote(String message) throws IOException {
        List<LayoutBlock> layoutBlocks = Blocks.asBlocks(
                getHeader("골라 주세요!"),
                Blocks.divider(),
                getSection(message),
                Blocks.divider(),
                Blocks.actions(getActionBlocks())
        );

        Slack.getInstance().send("https://hooks.slack.com/services/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", WebhookPayloads
                .payload(p -> p.text("골라 골라~")
                        .blocks(layoutBlocks)));
        System.out.println("전송됨");
        return message;
    }
}
