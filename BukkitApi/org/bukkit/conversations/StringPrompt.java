package org.bukkit.conversations;

import org.jetbrains.annotations.NotNull;

/**
 * StringPrompt是所有接受用户任意字符串输入的提示的基类.
 */
public abstract class StringPrompt implements Prompt {

    /**
     * 确保提示等待用户提供输入.
     * <p>
     * 原文：
     * Ensures that the prompt waits for the user to provide input.
     *
     * @param context 对话的上下文信息.
     * @return True.
     */
    @Override
    public boolean blocksForInput(@NotNull ConversationContext context) {
        return true;
    }
}
