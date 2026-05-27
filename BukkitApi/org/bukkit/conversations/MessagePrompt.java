package org.bukkit.conversations;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * MessagePrompt 是任何仅向用户显示消息且不需要输入的提示的基类。
 */
public abstract class MessagePrompt implements Prompt {

    public MessagePrompt() {
        super();
    }

    /**
     * 消息提示在继续之前从不等待用户输入。
     * <p>
     * 原文：
     * Message prompts never wait for user input before continuing.
     *
     * @param context 关于对话的上下文信息。
     * @return 始终返回 false。
     */
    @Override
    public boolean blocksForInput(@NotNull ConversationContext context) {
        return false;
    }

    /**
     * 接受并忽略任何用户输入，返回提示图中的下一个提示。
     * <p>
     * 原文：
     * Accepts and ignores any user input, returning the next prompt in the
     * prompt graph instead.
     *
     * @param context 关于对话的上下文信息。
     * @param input 被忽略。
     * @return 提示图中的下一个提示。
     */
    @Override
    @Nullable
    public Prompt acceptInput(@NotNull ConversationContext context, @Nullable String input) {
        return getNextPrompt(context);
    }

    /**
     * 覆盖此方法以返回提示图中的下一个提示。
     * <p>
     * 原文：
     * Override this method to return the next prompt in the prompt graph.
     *
     * @param context 关于对话的上下文信息。
     * @return 提示图中的下一个提示。
     */
    @Nullable
    protected abstract Prompt getNextPrompt(@NotNull ConversationContext context);
}
