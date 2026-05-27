package org.bukkit.conversations;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Prompt 是 {@link Conversation} 的主要组成部分。每个提示向用户显示文本，并可选择等待用户的响应。
 * 提示链接成一个有向图，表示对话流程。要停止对话，返回 END_OF_CONVERSATION 代替另一个 Prompt 对象。
 */
public interface Prompt extends Cloneable {

    /**
     * 用于指示对话结束的便捷常量。
     * <p>
     * 原文：
     * A convenience constant for indicating the end of a conversation.
     */
    static final Prompt END_OF_CONVERSATION = null;

    /**
     * 获取首次呈现此提示时向用户显示的文本。
     * <p>
     * 原文：
     * Gets the text to display to the user when this prompt is first
     * presented.
     *
     * @param context 关于对话的上下文信息。
     * @return 要显示的文本。
     */
    @NotNull
    String getPromptText(@NotNull ConversationContext context);

    /**
     * 检查此提示实现是否应等待用户输入或立即显示下一个提示。
     * <p>
     * 原文：
     * Checks to see if this prompt implementation should wait for user input
     * or immediately display the next prompt.
     *
     * @param context 关于对话的上下文信息。
     * @return 如果为 true，{@link Conversation} 将在继续之前等待输入。如果为 false，{@link #acceptInput(ConversationContext, String)} 将立即以 {@code null} 输入调用。
     */
    boolean blocksForInput(@NotNull ConversationContext context);

    /**
     * 接受并处理来自用户的输入。使用输入，返回提示图中的下一个 Prompt。
     * <p>
     * 原文：
     * Accepts and processes input from the user. Using the input, the next
     * Prompt in the prompt graph is returned.
     *
     * @param context 关于对话的上下文信息。
     * @param input 来自用户的输入文本。
     * @return 提示图中的下一个 Prompt。
     */
    @Nullable
    Prompt acceptInput(@NotNull ConversationContext context, @Nullable String input);
}
