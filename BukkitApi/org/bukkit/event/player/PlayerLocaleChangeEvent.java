package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 当玩家改变他们的语言设置时触发本事件.
 */
public class PlayerLocaleChangeEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    //
    private final String locale;

    public PlayerLocaleChangeEvent(Player who, String locale) {
        super(who);
        this.locale = locale;
    }

    /**
     * @see Player#getLocale()
     *
     * @return 玩家选择的语言
     */
    public String getLocale() {
        return locale;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
