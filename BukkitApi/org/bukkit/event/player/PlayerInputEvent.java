package org.bukkit.event.player;

import org.bukkit.Input;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家向服务器发送更新的输入时触发.
 *
 * @see Player#getCurrentInput()
 */
@ApiStatus.Experimental
public class PlayerInputEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Input input;

    public PlayerInputEvent(@NotNull final Player player, @NotNull final Input input) {
        super(player);
        this.input = input;
    }

    /**
     * 获取从此玩家接收到的新输入.
     * <p>
     * 原文：
     * Gets the new input received from this player.
     *
     * @return 新输入
     */
    @NotNull
    public Input getInput() {
        return input;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
