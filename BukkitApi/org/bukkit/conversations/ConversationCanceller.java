package org.bukkit.conversations;

/**
 * ConversationCanceller可以用来终止一个活跃的{@link
 * Conversation}. 一个Conversation可以有多个ConversationCanceller.
 */
public interface ConversationCanceller extends Cloneable {

    /**
     * 设置本ConversationCanceller可以取消的会话.
     * <p>
     * 原文:Sets the conversation this ConversationCanceller can optionally cancel.
     *
     * @param conversation 一个会话
     */
    public void setConversation(Conversation conversation);

    /**
     * 根据用户的输入反馈取消一个会话.
     * <p>
     * 原文:Cancels a conversation based on user input.
     *
     * @param context 关于会话的Context信息
     * @param input 用户的输入值
     * @return true取消该会话，false反之
     */
    public boolean cancelBasedOnInput(ConversationContext context, String input);

    /**
     * 允许某一{@link ConversationFactory}在创建一个新{@link Conversation}时
     * 复制这个ConversationCanceller.
     * <p>
     * 实现这个方法应当重置一切内部的对象状态.
     * <p>
     * 原文:Allows the {@link ConversationFactory} to duplicate this
     * ConversationCanceller when creating a new {@link Conversation}.
     * <p>
     * Implementing this method should reset any internal object state.
     *
     * @return 一个副本
     */
    public ConversationCanceller clone();
}
