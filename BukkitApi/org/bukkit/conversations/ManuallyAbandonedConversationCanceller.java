package org.bukkit.conversations;

import org.jetbrains.annotations.NotNull;

/**
 * ManuallyAbandonedConversationCanceller 仅用作 {@link ConversationAbandonedEvent} 的一部分，
 * 以指示对话是通过编程方式调用其 abandon() 方法手动放弃的。
 */
public class ManuallyAbandonedConversationCanceller implements ConversationCanceller {
    @Override
    public void setConversation(@NotNull Conversation conversation) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean cancelBasedOnInput(@NotNull ConversationContext context, @NotNull String input) {
        throw new UnsupportedOperationException();
    }

    @Override
    @NotNull
    public ConversationCanceller clone() {
        throw new UnsupportedOperationException();
    }
}
