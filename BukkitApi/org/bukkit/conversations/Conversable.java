package org.bukkit.conversations;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Conversable 接口用于表示可以进行对话的对象。
 */
public interface Conversable {

    /**
     * 测试 Conversable 对象是否积极参与对话。
     * <p>
     * 原文：
     * Tests to see of a Conversable object is actively engaged in a
     * conversation.
     *
     * @return 如果对话正在进行中则返回 true。
     */
    public boolean isConversing();

    /**
     * 接受输入到活动对话中。如果没有对话正在进行，此方法不执行任何操作。
     * <p>
     * 原文：
     * Accepts input into the active conversation. If no conversation is in
     * progress, this method does nothing.
     *
     * @param input 输入到对话中的消息。
     */
    public void acceptConversationInput(@NotNull String input);

    /**
     * 与 Conversation 对象进行对话。
     * <p>
     * 原文：
     * Enters into a dialog with a Conversation object.
     *
     * @param conversation 要开始的对话。
     * @return 如果对话应继续则返回 true，如果已排队则返回 false。
     */
    public boolean beginConversation(@NotNull Conversation conversation);

    /**
     * 放弃一个活动对话。
     * <p>
     * 原文：
     * Abandons an active conversation.
     *
     * @param conversation 要放弃的对话。
     */
    public void abandonConversation(@NotNull Conversation conversation);

    /**
     * 放弃一个活动对话。
     * <p>
     * 原文：
     * Abandons an active conversation.
     *
     * @param conversation 要放弃的对话。
     * @param details 关于对话被放弃原因的详细信息。
     */
    public void abandonConversation(@NotNull Conversation conversation, @NotNull ConversationAbandonedEvent details);

    /**
     * 向此发送者发送原始消息。
     * <p>
     * 原文：
     * Sends this sender a message raw
     *
     * @param message 要显示的消息。
     */
    public void sendRawMessage(@NotNull String message);

    /**
     * 向此发送者发送原始消息。
     * <p>
     * 原文：
     * Sends this sender a message raw
     *
     * @param message 要显示的消息。
     * @param sender 此消息的发送者。
     */
    public void sendRawMessage(@Nullable UUID sender, @NotNull String message);
}
