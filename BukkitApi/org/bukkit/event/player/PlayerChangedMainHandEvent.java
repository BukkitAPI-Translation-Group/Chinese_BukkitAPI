package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.MainHand;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家在客户端设置改变主手时触发本事件.
 */
public class PlayerChangedMainHandEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final MainHand mainHand;

    public PlayerChangedMainHandEvent(@NotNull Player who, @NotNull MainHand mainHand) {
        super(who);
        this.mainHand = mainHand;
    }

    /**
     * 获取玩家的新主手.旧的主手依然可以在此期间通过 {@link Player#getMainHand()} 获取到.
     * <p>
     * 原文:Gets the new main hand of the player. The old hand is still momentarily
     * available via {@link Player#getMainHand()}.
     *
     * @return 玩家的新{@link MainHand}
     */
    @NotNull
    public MainHand getMainHand() {
        return mainHand;
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