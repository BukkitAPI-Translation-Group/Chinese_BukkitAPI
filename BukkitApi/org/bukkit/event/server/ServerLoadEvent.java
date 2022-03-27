package org.bukkit.event.server;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当服务器启动/重载完成时调用.
 */
public class ServerLoadEvent extends ServerEvent {

    /**
     * 代表事件完成时, 服务器成功加载的方式.
     */
    public enum LoadType {
        STARTUP, RELOAD;
    }

    private static final HandlerList handlers = new HandlerList();
    private final LoadType type;

    /**
     * 以指定加载类型创建一个 {@code ServerLoadEvent}.
     * <p>
     * 原文:
     * Creates a {@code ServerLoadEvent} with a given loading type.
     *
     * @param type 服务器加载类型
     */
    public ServerLoadEvent(@NotNull LoadType type) {
        this.type = type;
    }

    /**
     * 获取服务器是以何种形式完成加载的.
     * <p>
     * 原文:
     * Gets the context in which the server was loaded.
     *
     * @return 服务器加载类型
     */
    @NotNull
    public LoadType getType() {
        return type;
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
