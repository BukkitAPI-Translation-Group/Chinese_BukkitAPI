package org.bukkit.conversations;

import java.util.EventObject;

/**
 * ConversationAbandonedEvent包含一个被终止的会话的细节信息.
 */
public class ConversationAbandonedEvent extends EventObject {

    private ConversationContext context;
    private ConversationCanceller canceller;

    public ConversationAbandonedEvent(Conversation conversation) {
        this(conversation, null);
    }

    public ConversationAbandonedEvent(Conversation conversation, ConversationCanceller canceller) {
        super(conversation);
        this.context = conversation.getContext();
        this.canceller = canceller;
    }

    /**
     * 获取终止该会话的{@link ConversationCanceller}.
     * <p>
     * 原文:Gets the object that caused the conversation to be abandoned.
     *
     * @return 终止该会话的{@link ConversationCanceller}
     */
    public ConversationCanceller getCanceller() {
        return canceller;
    }

    /**
     * 获取这个被终止的会话的上下文.
     * <p>
     * 原文:Gets the abandoned conversation's conversation context.
     *
     * @return 被终止的对话的上下文
     */
    public ConversationContext getContext() {
        return context;
    }

    /**
     * 指示该对话是怎样被终止的 - 在对话提示流程完成后自然终止
     * 还是较早地通过{@link ConversationCanceller}终止.
     * <p>
     * Indicates how the conversation was abandoned - naturally as part of the
     * prompt chain or prematurely via a {@link ConversationCanceller}.
     *
     * @return 若会话是由于{@link Prompt}返回了空值或下一个prompt被优雅地终止返回true;
     * 若会话是被ConversationCanceller终止的返回false.
     */
    public boolean gracefulExit() {
        return canceller == null;
    }
}
