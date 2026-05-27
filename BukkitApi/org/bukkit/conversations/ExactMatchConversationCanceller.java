package org.bukkit.conversations;

import org.jetbrains.annotations.NotNull;

/**
 * ExactMatchConversationCanceller 会在用户输入精确匹配的字符串时取消对话。
 */
public class ExactMatchConversationCanceller implements ConversationCanceller {
    private String escapeSequence;

    /**
     * 构建一个 ExactMatchConversationCanceller。
     * <p>
     * 原文：
     * Builds an ExactMatchConversationCanceller.
     *
     * @param escapeSequence 如果用户输入将取消对话的字符串。
     */
    public ExactMatchConversationCanceller(@NotNull String escapeSequence) {
        this.escapeSequence = escapeSequence;
    }

    @Override
    public void setConversation(@NotNull Conversation conversation) {}

    @Override
    public boolean cancelBasedOnInput(@NotNull ConversationContext context, @NotNull String input) {
        return input.equals(escapeSequence);
    }

    @Override
    @NotNull
    public ConversationCanceller clone() {
        return new ExactMatchConversationCanceller(escapeSequence);
    }
}
