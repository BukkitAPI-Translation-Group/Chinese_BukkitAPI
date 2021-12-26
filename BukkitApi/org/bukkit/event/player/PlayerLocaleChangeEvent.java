package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家改变他们的语言设置时触发本事件.
 */
public class PlayerLocaleChangeEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final String locale;

    public PlayerLocaleChangeEvent(@NotNull Player who, @NotNull String locale) {
        super(who);
        this.locale = locale;
    }

    /**
     * @return 玩家选择的语言
     * @see Player#getLocale()
     */
    @NotNull
    public String getLocale() {
        return locale;
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
