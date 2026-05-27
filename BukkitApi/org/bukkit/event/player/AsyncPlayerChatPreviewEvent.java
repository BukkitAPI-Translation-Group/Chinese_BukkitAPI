package org.bukkit.event.player;

import java.util.Set;
import org.bukkit.Warning;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 用于聊天预览的格式化。如果使用此事件，则对应的 {@link AsyncPlayerChatEvent} 的结果
 * <b>必须</b>以相同的方式进行格式化。
 *
 * @deprecated 聊天预览功能已被移除
 */
@Deprecated(since = "1.19.1")
@Warning(false)
public class AsyncPlayerChatPreviewEvent extends AsyncPlayerChatEvent {

    private static final HandlerList handlers = new HandlerList();

    public AsyncPlayerChatPreviewEvent(final boolean async, @NotNull final Player who, @NotNull final String message, @NotNull final Set<Player> players) {
        super(async, who, message, players);
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