package org.bukkit.conversations;

import org.jetbrains.annotations.NotNull;

/**
 * ConversationPrefix实现在对话的所有输出前添加前缀.
 * ConversationPrefix可用于显示插件名称或随对话进展显示对话状态.
 */
public interface ConversationPrefix {

    /**
     * 获取发送给玩家的每条消息前使用的前缀.
     *
     * @param context 对话的上下文信息.
     * @return 前缀文本.
     */
    @NotNull
    String getPrefix(@NotNull ConversationContext context);
}
