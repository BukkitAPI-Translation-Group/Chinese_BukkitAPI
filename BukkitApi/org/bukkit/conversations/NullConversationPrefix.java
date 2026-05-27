package org.bukkit.conversations;

import org.jetbrains.annotations.NotNull;

/**
 * NullConversationPrefix是一个{@link ConversationPrefix}实现, 不在对话输出前显示任何内容.
 */
public class NullConversationPrefix implements ConversationPrefix {

    /**
     * 在每条对话消息前添加空字符串.
     * <p>
     * 原文：
     * Prepends each conversation message with an empty string.
     *
     * @param context 对话的上下文信息.
     * @return 空字符串.
     */
    @Override
    @NotNull
    public String getPrefix(@NotNull ConversationContext context) {
        return "";
    }
}
