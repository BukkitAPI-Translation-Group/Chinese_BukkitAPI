package org.bukkit.conversations;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * PlayerNamePrompt 是任何需要玩家输入另一个玩家名称的提示的基类。
 */
public abstract class PlayerNamePrompt extends ValidatingPrompt {
    private Plugin plugin;

    public PlayerNamePrompt(@NotNull Plugin plugin) {
        super();
        this.plugin = plugin;
    }

    @Override
    protected boolean isInputValid(@NotNull ConversationContext context, @NotNull String input) {
        return plugin.getServer().getPlayer(input) != null;
    }

    @Nullable
    @Override
    protected Prompt acceptValidatedInput(@NotNull ConversationContext context, @NotNull String input) {
        return acceptValidatedInput(context, plugin.getServer().getPlayer(input));
    }

    /**
     * 覆盖此方法以对用户的玩家名称响应执行某些操作。
     * <p>
     * 原文：
     * Override this method to perform some action with the user's player name
     * response.
     *
     * @param context 关于对话的上下文信息。
     * @param input 用户的玩家名称响应。
     * @return 提示图中的下一个 {@link Prompt}。
     */
    @Nullable
    protected abstract Prompt acceptValidatedInput(@NotNull ConversationContext context, @NotNull Player input);
}
