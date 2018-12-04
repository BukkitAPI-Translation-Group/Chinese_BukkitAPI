package org.bukkit.conversations;

import java.util.EventListener;

/**
 */
public interface ConversationAbandonedListener extends EventListener {
    /**
     * 当一个{@link Conversation}被终止时调用此方法.
     * <p>
     * 原文:Called whenever a {@link Conversation} is abandoned.
     *
     * @param abandonedEvent 包含关于会话被终止的细节的事件对象
     */
    public void conversationAbandoned(ConversationAbandonedEvent abandonedEvent);
}
