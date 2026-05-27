package org.bukkit.conversations;

import java.util.Map;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * ConversationContext 通过让开发者访问对话主题和一个通用映射来存储在所有 {@link Prompt} 调用之间共享的值，
 * 从而在提示图中的节点之间提供连续性。
 */
public class ConversationContext {
    private final Conversable forWhom;
    private final Map<Object, Object> sessionData;
    private final Plugin plugin;

    /**
     * @param plugin 拥有此对话的插件。
     * @param forWhom 对话的主题。
     * @param initialSessionData 放入 sessionData 映射中的任何初始值。
     */
    public ConversationContext(@Nullable Plugin plugin, @NotNull Conversable forWhom, @NotNull Map<Object, Object> initialSessionData) {
        this.plugin = plugin;
        this.forWhom = forWhom;
        this.sessionData = initialSessionData;
    }

    /**
     * 获取拥有此对话的插件。
     * <p>
     * 原文：
     * Gets the plugin that owns this conversation.
     *
     * @return 拥有此对话的插件。
     */
    @Nullable
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * 获取对话的主题。
     * <p>
     * 原文：
     * Gets the subject of the conversation.
     *
     * @return 对话的主题。
     */
    @NotNull
    public Conversable getForWhom() {
        return forWhom;
    }

    /**
     * 获取底层的 sessionData 映射。可以直接修改以操作会话数据。
     * <p>
     * 原文：
     * Gets the underlying sessionData map.
     *
     * May be directly modified to manipulate session data.
     *
     * @return 完整的 sessionData 映射。
     */
    @NotNull
    public Map<Object, Object> getAllSessionData() {
        return sessionData;
    }

    /**
     * 获取在所有 {@link Prompt} 调用之间共享的会话数据。使用此方法作为在对话发展过程中通过每个 Prompt 传递数据的方式。
     * <p>
     * 原文：
     * Gets session data shared between all {@link Prompt} invocations. Use
     * this as a way to pass data through each Prompt as the conversation
     * develops.
     *
     * @param key 会话数据的键。
     * @return 请求的会话数据。
     */
    @Nullable
    public Object getSessionData(@NotNull Object key) {
        return sessionData.get(key);
    }

    /**
     * 设置在所有 {@link Prompt} 调用之间共享的会话数据。使用此方法作为在对话发展过程中通过每个提示传递数据的方式。
     * <p>
     * 原文：
     * Sets session data shared between all {@link Prompt} invocations. Use
     * this as a way to pass data through each prompt as the conversation
     * develops.
     *
     * @param key 会话数据的键。
     * @param value 会话数据的值。
     */
    public void setSessionData(@NotNull Object key, @Nullable Object value) {
        sessionData.put(key, value);
    }
}
