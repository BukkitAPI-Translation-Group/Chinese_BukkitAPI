package org.bukkit.conversations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * ConversationFactory 负责从预定义模板创建 {@link Conversation}。
 * ConversationFactory 通常在插件实例化时创建，并在每次用户与插件发起对话时构建一个 Conversation。
 * 每个 Conversation 维护自己的状态，并根据需要回调到插件中。
 * <p>
 * ConversationFactory 实现了流式 API，允许将参数设置为构造函数的扩展。
 */
public class ConversationFactory {

    protected Plugin plugin;
    protected boolean isModal;
    protected boolean localEchoEnabled;
    protected ConversationPrefix prefix;
    protected Prompt firstPrompt;
    protected Map<Object, Object> initialSessionData;
    protected String playerOnlyMessage;
    protected List<ConversationCanceller> cancellers;
    protected List<ConversationAbandonedListener> abandonedListeners;

    /**
     * 构造一个 ConversationFactory。
     * <p>
     * 原文：
     * Constructs a ConversationFactory.
     *
     * @param plugin 拥有此工厂的插件。
     */
    public ConversationFactory(@NotNull Plugin plugin) {
        this.plugin = plugin;
        isModal = true;
        localEchoEnabled = true;
        prefix = new NullConversationPrefix();
        firstPrompt = Prompt.END_OF_CONVERSATION;
        initialSessionData = new HashMap<Object, Object>();
        playerOnlyMessage = null;
        cancellers = new ArrayList<ConversationCanceller>();
        abandonedListeners = new ArrayList<ConversationAbandonedListener>();
    }

    /**
     * 设置此工厂创建的所有 {@link Conversation} 的模态性。如果对话是模态的，则在对话期间抑制所有指向玩家的消息。
     * <p>
     * 默认值为 True。
     * <p>
     * 原文：
     * Sets the modality of all {@link Conversation}s created by this factory.
     * If a conversation is modal, all messages directed to the player are
     * suppressed for the duration of the conversation.
     * <p>
     * The default is True.
     *
     * @param modal 所有待创建对话的模态性。
     * @return 此对象。
     */
    @NotNull
    public ConversationFactory withModality(boolean modal) {
        isModal = modal;
        return this;
    }

    /**
     * 设置此工厂创建的所有 {@link Conversation} 的本地回显状态。如果启用了本地回显，则提交到对话的任何文本都会被回显到提交者的聊天窗口中。
     * <p>
     * 原文：
     * Sets the local echo status for all {@link Conversation}s created by
     * this factory. If local echo is enabled, any text submitted to a
     * conversation gets echoed back into the submitter's chat window.
     *
     * @param localEchoEnabled 本地回显的状态。
     * @return 此对象。
     */
    @NotNull
    public ConversationFactory withLocalEcho(boolean localEchoEnabled) {
        this.localEchoEnabled = localEchoEnabled;
        return this;
    }

    /**
     * 设置此前置所有生成对话输出的 {@link ConversationPrefix}。
     * <p>
     * 默认值为 {@link NullConversationPrefix}。
     * <p>
     * 原文：
     * Sets the {@link ConversationPrefix} that prepends all output from all
     * generated conversations.
     * <p>
     * The default is a {@link NullConversationPrefix};
     *
     * @param prefix 要使用的 ConversationPrefix。
     * @return 此对象。
     */
    @NotNull
    public ConversationFactory withPrefix(@NotNull ConversationPrefix prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * 设置自动放弃所有生成对话之前等待的非活动秒数。
     * <p>
     * 默认值为 600 秒（5 分钟）。
     * <p>
     * 原文：
     * Sets the number of inactive seconds to wait before automatically
     * abandoning all generated conversations.
     * <p>
     * The default is 600 seconds (5 minutes).
     *
     * @param timeoutSeconds 等待的秒数。
     * @return 此对象。
     */
    @NotNull
    public ConversationFactory withTimeout(int timeoutSeconds) {
        return withConversationCanceller(new InactivityConversationCanceller(plugin, timeoutSeconds));
    }

    /**
     * 设置在所有生成对话中使用的第一个提示。
     * <p>
     * 默认值为 Prompt.END_OF_CONVERSATION。
     * <p>
     * 原文：
     * Sets the first prompt to use in all generated conversations.
     * <p>
     * The default is Prompt.END_OF_CONVERSATION.
     *
     * @param firstPrompt 第一个提示。
     * @return 此对象。
     */
    @NotNull
    public ConversationFactory withFirstPrompt(@Nullable Prompt firstPrompt) {
        this.firstPrompt = firstPrompt;
        return this;
    }

    /**
     * 设置用于填充对话上下文 sessionData 映射的任何初始数据。
     * <p>
     * 原文：
     * Sets any initial data with which to populate the conversation context
     * sessionData map.
     *
     * @param initialSessionData 对话上下文的初始 sessionData。
     * @return 此对象。
     */
    @NotNull
    public ConversationFactory withInitialSessionData(@NotNull Map<Object, Object> initialSessionData) {
        this.initialSessionData = initialSessionData;
        return this;
    }

    /**
     * 设置玩家输入，当接收到时将立即终止对话。
     * <p>
     * 原文：
     * Sets the player input that, when received, will immediately terminate
     * the conversation.
     *
     * @param escapeSequence 终止对话的输入。
     * @return 此对象。
     */
    @NotNull
    public ConversationFactory withEscapeSequence(@NotNull String escapeSequence) {
        return withConversationCanceller(new ExactMatchConversationCanceller(escapeSequence));
    }

    /**
     * 将 {@link ConversationCanceller} 添加到构造的对话中。
     * <p>
     * 原文：
     * Adds a {@link ConversationCanceller} to constructed conversations.
     *
     * @param canceller 要添加的 {@link ConversationCanceller}。
     * @return 此对象。
     */
    @NotNull
    public ConversationFactory withConversationCanceller(@NotNull ConversationCanceller canceller) {
        cancellers.add(canceller);
        return this;
    }

    /**
     * 阻止此工厂为非玩家 {@link Conversable} 对象创建对话。
     * <p>
     * 原文：
     * Prevents this factory from creating a conversation for non-player
     * {@link Conversable} objects.
     *
     * @param playerOnlyMessage 返回给非玩家的消息，以代替开始对话。
     * @return 此对象。
     */
    @NotNull
    public ConversationFactory thatExcludesNonPlayersWithMessage(@Nullable String playerOnlyMessage) {
        this.playerOnlyMessage = playerOnlyMessage;
        return this;
    }

    /**
     * 将 {@link ConversationAbandonedListener} 添加到此工厂构造的所有对话中。
     * <p>
     * 原文：
     * Adds a {@link ConversationAbandonedListener} to all conversations
     * constructed by this factory.
     *
     * @param listener 要添加的监听器。
     * @return 此对象。
     */
    @NotNull
    public ConversationFactory addConversationAbandonedListener(@NotNull ConversationAbandonedListener listener) {
        abandonedListeners.add(listener);
        return this;
    }

    /**
     * 根据此工厂设置的默认值构造一个 {@link Conversation}。
     * <p>
     * 原文：
     * Constructs a {@link Conversation} in accordance with the defaults set
     * for this factory.
     *
     * @param forWhom 新对话所中介的实体。
     * @return 一个新的对话。
     */
    @NotNull
    public Conversation buildConversation(@NotNull Conversable forWhom) {
        //Abort conversation construction if we aren't supposed to talk to non-players
        if (playerOnlyMessage != null && !(forWhom instanceof Player)) {
            return new Conversation(plugin, forWhom, new NotPlayerMessagePrompt());
        }

        //Clone any initial session data
        Map<Object, Object> copiedInitialSessionData = new HashMap<Object, Object>();
        copiedInitialSessionData.putAll(initialSessionData);

        //Build and return a conversation
        Conversation conversation = new Conversation(plugin, forWhom, firstPrompt, copiedInitialSessionData);
        conversation.setModal(isModal);
        conversation.setLocalEchoEnabled(localEchoEnabled);
        conversation.setPrefix(prefix);

        //Clone the conversation cancellers
        for (ConversationCanceller canceller : cancellers) {
            conversation.addConversationCanceller(canceller.clone());
        }

        //Add the ConversationAbandonedListeners
        for (ConversationAbandonedListener listener : abandonedListeners) {
            conversation.addConversationAbandonedListener(listener);
        }

        return conversation;
    }

    private class NotPlayerMessagePrompt extends MessagePrompt {

        @Override
        @NotNull
        public String getPromptText(@NotNull ConversationContext context) {
            return playerOnlyMessage;
        }

        @Nullable
        @Override
        protected Prompt getNextPrompt(@NotNull ConversationContext context) {
            return Prompt.END_OF_CONVERSATION;
        }
    }
}
